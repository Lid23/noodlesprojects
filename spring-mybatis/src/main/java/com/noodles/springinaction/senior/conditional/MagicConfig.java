package com.noodles.springinaction.senior.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicConfig {

  /*
  * @Author: Sal
  * @Description:条件化实例化对象，当满足MagicExistsCondition条件时，对象实例化
  * @Date:2018/6/7 14:31
  */
  @Bean
  @Conditional(MagicExistsCondition.class)
  public MagicBean magicBean() {
    return new MagicBean();
  }
  
}