package com.example.demo;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @SneakyThrows
  public String longRunningProcess() {
    Thread.sleep(5000);
    return "Result";
  }
}
