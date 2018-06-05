package com.github.excarlibur.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenxuewei on 2018/6/5.
 */
@RequestMapping("/feign")
public interface HelloService {

  @GetMapping("/hello")
  Object hello();

}
