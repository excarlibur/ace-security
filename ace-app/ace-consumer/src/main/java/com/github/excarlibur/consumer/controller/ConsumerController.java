package com.github.excarlibur.consumer.controller;

import com.github.excarlibur.consumer.service.FeignExtendService;
import com.github.excarlibur.consumer.service.HystrixService;
import com.github.excarlibur.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chenxuewei on 2018/5/28.
 */
@RestController
public class ConsumerController {

  @Autowired
  LoadBalancerClient loadBalancerClient;

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  ProviderService providerService;

  @Autowired
  HystrixService hystrixService;

  @Autowired
  FeignExtendService feignExtendService;


  //Ribbon+Hystrix服务容错保护
  @GetMapping("/ribbon_hystrix_client")
  public String ribbonHystrixClient() {
    return hystrixService.hystrix();
  }

  //用feign调用
  @GetMapping("/feign_client")
  public String feignClient() {
    return providerService.hello();
  }

  @GetMapping("/feign_retry")
  public String feignRetry() {
    String result =  providerService.retryHello();
    return result;
  }


  //feign的继承特性
  @GetMapping("/feign_client_extend")
  public Object feignExtendService() {
    return feignExtendService.extendFeature();
  }

}
