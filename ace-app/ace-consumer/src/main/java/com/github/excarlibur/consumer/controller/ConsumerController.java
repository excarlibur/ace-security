package com.github.excarlibur.consumer.controller;

import com.github.excarlibur.consumer.service.FeignExtendService;
import com.github.excarlibur.consumer.service.HystrixService;
import com.github.excarlibur.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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

  //手动调用
  @GetMapping("/load_balance_client")
  public String loadBalancerClient() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("consul-provider");
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
    System.out.println(url);
    String result = new RestTemplate().getForObject(url, String.class);
    return result;
  }

  //用Ribbon做客户端负载均衡
  @GetMapping("/ribbon_client")
  public String ribbonClient() {
    String result =  restTemplate.getForObject("http://consul-provider/hello", String.class);
    return result;
  }

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

  //feign的继承特性
  @GetMapping("/feign_client_extend")
  public Object feignExtendService() {
    return feignExtendService.extendFeature();
  }

}
