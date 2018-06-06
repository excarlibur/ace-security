package com.github.excarlibur.provider.controller;

import com.github.excarlibur.api.dto.User;
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
//public class ProviderController implements FeignService {
  public class ProviderController  {

  @Autowired
  DiscoveryClient discoveryClient;


  @GetMapping("/hello")
  public String dc() {
    new User();
    discoveryClient.description();
    String services = discoveryClient.getLocalServiceInstance().getServiceId()+":hello";
    System.out.println(services);
    return services;
  }

//  @Override
//  public Object extendFeature() {
//    return new User("admin",10);
//  }
}
