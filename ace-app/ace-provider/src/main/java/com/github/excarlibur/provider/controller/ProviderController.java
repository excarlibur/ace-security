package com.github.excarlibur.provider.controller;

import com.github.excarlibur.api.FeignService;
import com.github.excarlibur.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  DiscoveryClient discoveryClient;


  @GetMapping("/hello")
  public String dc() {
    discoveryClient.description();
    String services = discoveryClient.getLocalServiceInstance().getServiceId()+":hello";
    System.out.println(services);
    return services;
  }

  @Override
  public Object extendFeature() {
    return new User("admin",10);
  }
}
