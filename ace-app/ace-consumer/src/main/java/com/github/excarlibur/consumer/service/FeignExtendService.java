package com.github.excarlibur.consumer.service;

import com.github.excarlibur.api.feign.FeignService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by chenxuewei on 2018/6/6.
 */
@FeignClient("consul-provider")
public interface FeignExtendService extends FeignService {

}
