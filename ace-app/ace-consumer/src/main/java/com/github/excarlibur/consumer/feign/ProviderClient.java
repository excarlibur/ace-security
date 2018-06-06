package com.github.excarlibur.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by chenxuewei on 2018/5/28.
 */
@FeignClient("consul-provider")
public interface ProviderClient {

  @GetMapping("/consumer")
  String consumer();

}
