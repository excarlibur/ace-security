package com.github.excarlibur.api.feign;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by chenxuewei on 2018/6/5.
 */
public interface FeignService {

  @GetMapping("/extend_feature")
  Object extendFeature();
}
