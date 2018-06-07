package com.github.excarlibur.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chenxuewei on 2018/6/7.
 */
@Service
public class HystrixService {

  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "fallback")
  public String hystrix() {
    return restTemplate.getForObject("http://consul-provider/hystrix", String.class);
  }

  public String fallback() {
    return "fallback";
  }
}
