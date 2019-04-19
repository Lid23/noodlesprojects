package com.noodles.springinaction.senior.scopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
* @Author: Sal
* @Description:Spring中的对象范围
* @Date:2018/6/7 14:33
*/
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Notepad {

  // the details of this class are inconsequential to this example
}
