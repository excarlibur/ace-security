package com.github.excarlibur.consumer.controller;

import com.github.excarlibur.consumer.feign.FeignExtendService;
import com.github.excarlibur.consumer.feign.ProviderClient;
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
  ProviderClient providerClient;

  @Autowired
  FeignExtendService feignExtendService;


  @GetMapping("/consumer")
  public String dc() {
//    ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
//    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
//    System.out.println(url);
//    String result = restTemplate.getForObject(url, String.class);

//    String result =  restTemplate.getForObject("http://eureka-provider/dc", String.class);

    return providerClient.consumer();
  }


  //手动调用
  @GetMapping("/load_balance_Client")
  public String loadBalancerClient() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("consul-provider");
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
    System.out.println(url);
    String result = new RestTemplate().getForObject(url, String.class);

//    String result =  restTemplate.getForObject("http://consul-provider/hello", String.class);
    return result;
  }

  @GetMapping("/consumer_feign_extend")
  public Object feignExtendService() {
    return feignExtendService.extendFeature();
  }


}
