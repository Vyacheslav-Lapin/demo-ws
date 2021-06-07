package ru.cb.demows.controller;

import static javax.jws.soap.SOAPBinding.Style.RPC;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = RPC)
public class Hello {
  public String sayHello(String name) {
    return "Hello, " + name;
  }
}
