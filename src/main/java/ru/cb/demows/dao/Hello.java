package ru.cb.demows.dao;

import lombok.val;
import ru.cb.demows.wsclient.HelloService;

public class Hello {
  public static void main(String... __) {
    val service = new HelloService();
    val hello = service.getHelloPort();
    val text = hello.sayHello("Henry");
    System.out.println(text);
  }
}
