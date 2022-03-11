package ru.cb.demows.controller;

//@WebService
//@SOAPBinding(style = RPC)
public class Hello {
  public String sayHello(String name) {
    return "Hello, " + name;
  }
}
