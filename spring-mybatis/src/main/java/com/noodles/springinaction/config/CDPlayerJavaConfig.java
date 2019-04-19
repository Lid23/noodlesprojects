package com.noodles.springinaction.config;

import com.noodles.springinaction.bean.CDPlayer;
import com.noodles.springinaction.bean.CompactDisc;
import com.noodles.springinaction.bean.SgtPeppers;
import org.springframework.context.annotation.Bean;

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
public class CDPlayerJavaConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        return  new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        CDPlayer cdPlayer = new CDPlayer( compactDisc );
        cdPlayer.setCompactDisc(compactDisc);

        return cdPlayer;
    }

}
