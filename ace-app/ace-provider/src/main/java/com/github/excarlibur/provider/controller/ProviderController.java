package com.github.excarlibur.provider.controller;

import com.github.excarlibur.api.dto.User;
import com.github.excarlibur.api.feign.FeignService;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxuewei on 2018/5/28.
 */
@RestController
@RequestMapping
public class ProviderController implements FeignService {

  private final static Logger logger = LoggerFactory.getLogger(ProviderController.class);

  @Value("${from}")
  private String from;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/hello")
  public String hello() {
    String services = discoveryClient.getLocalServiceInstance().getServiceId()+":hello";
    logger.info(services);
    return services;
  }

  @GetMapping("/hello_timeout")
  public String helloTimeout() throws InterruptedException {
    String services = discoveryClient.getLocalServiceInstance().getServiceId()+":hello";
    int sleepTime = new Random().nextInt(3000);
    logger.info("sleepTime:"+sleepTime);
    Thread.sleep(sleepTime);
    logger.info(services);
    return services;
  }

  @GetMapping("/hystrix")
  public String hystrix() throws InterruptedException {
    Thread.sleep(5000L);
    String services = discoveryClient.getLocalServiceInstance().getServiceId()+":hello";
    logger.info(services);
    return services;
  }

  @GetMapping("/from")
  public String from()  {
    return from;
  }

  @Override
  public Object extendFeature() {
    return new User("admin",10);
  }
}
