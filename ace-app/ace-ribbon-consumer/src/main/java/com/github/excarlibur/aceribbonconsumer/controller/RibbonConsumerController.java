package com.github.excarlibur.aceribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chenxuewei on 2018/6/11.
 */
@RestController
public class RibbonConsumerController {

  @Autowired
  LoadBalancerClient loadBalancerClient;

  @Autowired
  RestTemplate restTemplate;

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

  @GetMapping("/ribbon_retry")
  public String ribbonRetry() {
    String result =  restTemplate.getForObject("http://consul-provider/hello_timeout", String.class);
    return result;
  }

}
