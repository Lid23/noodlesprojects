package com.noodles.springinaction.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CDPlayer
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/17 16:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 16:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class CDPlayer implements  MediaPlayer{

    private CompactDisc compactDisc;

    @Autowired
    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    /*@Autowired(required = false)*/
    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    public void play(){
        compactDisc.play();
    }
}
