package com.github.excarlibur.consumer.feign;

import com.github.excarlibur.api.FeignService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by chenxuewei on 2018/6/6.
 */
@FeignClient("consul-provider")
public interface FeignExtendService extends FeignService{

}
