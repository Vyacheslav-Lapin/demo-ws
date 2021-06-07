package ru.cb.demows;

import javax.xml.ws.Endpoint;
import ru.cb.demows.controller.Hello;

public class CortractLastWsApplication {
  public static void main(String... __) {
    String url = "http://localhost:1212/hello";
    Endpoint.publish(url, new Hello());
    System.out.printf("Service started @ %s%n", url);
  }
}
