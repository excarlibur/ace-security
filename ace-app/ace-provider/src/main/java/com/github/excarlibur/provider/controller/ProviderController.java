package com.github.excarlibur.provider.controller;

import com.github.excarlibur.api.HelloService;
import com.github.excarlibur.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxuewei on 2018/5/28.
 */
@RestController
public class ProviderController implements HelloService {

  @Autowired
  DiscoveryClient discoveryClient;


  @GetMapping("/dc")
  public String dc() {
    String services = "Services: " + discoveryClient.getServices()+"======="+discoveryClient.getLocalServiceInstance().getPort();
    System.out.println(services);
    return services;
  }

  @Override
  public Object hello() {
    return new User("admin",10);
  }
}
