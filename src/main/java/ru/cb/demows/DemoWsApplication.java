package ru.cb.demows;

import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@EnableFeignClients
@SpringBootApplication
public class DemoWsApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoWsApplication.class, args);
  }

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
    val messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(applicationContext);
    return new ServletRegistrationBean<>(messageDispatcherServlet, "/medium/ws/*");
  }

  @Bean
  public Wsdl11Definition calculatorDemo(){
    val simpleWsdl11Definition = new SimpleWsdl11Definition();
    simpleWsdl11Definition.setWsdl(new ClassPathResource("/wsdl/calculator.wsdl"));
    return simpleWsdl11Definition;
  }
}
