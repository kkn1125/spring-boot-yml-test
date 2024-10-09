package com.outside.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {
  @Autowired
  Environment env;

  @Value("${custom.username}")
  private String username;

  @Value("${custom.test:default}")
  private String test;

  @Value("${kimson.test:none}")
  private String external;

  @Value("${external.name:external_none}")
  private String external2;

  @Value("${relative.name:none_name}")
  private String relative;

  @GetMapping("")
  public HashMap<String, Object> main() {
    System.out.println("#####start#####");
    System.out.println(relative);
    System.out.println(external);
    System.out.println(external2);
    System.out.println(env.getProperty("ANDROID_HOME"));
    System.out.println(env.getProperty("MY_NAME"));
    System.out.println(env.getProperty("spring.application.name"));
    System.out.println(test);
    HashMap<String, Object> map = new HashMap<>();
    map.put("test", 123);
    map.put("name", username);
    return map;
  }

}
