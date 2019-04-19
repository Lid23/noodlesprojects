package com.noodles.springinaction.config;

import noodles.springaction.bean.CompactDisc;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: CDPlayerConfig
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/17 15:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 15:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
//@Configuration
//默认扫描与配置类相同的包
//@ComponentScan
//扫描基础包
//@ComponentScan(basePackages = {"noodles.springaction"})
//类所在的包作为组件扫描的基础包
@ComponentScan(basePackageClasses = {CompactDisc.class})
public class CDPlayerConfig {

}
