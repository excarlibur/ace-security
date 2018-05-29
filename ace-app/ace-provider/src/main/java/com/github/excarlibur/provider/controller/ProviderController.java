package com.github.excarlibur.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxuewei on 2018/5/28.
 */
@RestController
public class ProviderController {

  @Autowired
  DiscoveryClient discoveryClient;


  @GetMapping("/dc")
  public String dc() {
    String services = "Services: " + discoveryClient.getServices()+"======="+discoveryClient.getLocalServiceInstance().getPort();
    System.out.println(services);
    return services;
  }

}
