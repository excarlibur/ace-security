package com.github.excarlibur.consumer.controller;

import com.github.excarlibur.consumer.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxuewei on 2018/5/28.
 */
@RestController
public class ConsumerController {

//  @Autowired
//  LoadBalancerClient loadBalancerClient;
//  @Autowired
//  RestTemplate restTemplate;

  @Autowired
  ProviderClient providerClient;

  @GetMapping("/consumer")
  public String dc() {
//    ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
//    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
//    System.out.println(url);
//    String result = restTemplate.getForObject(url, String.class);

//    String result =  restTemplate.getForObject("http://eureka-provider/dc", String.class);

    return providerClient.consumer();
  }

}
