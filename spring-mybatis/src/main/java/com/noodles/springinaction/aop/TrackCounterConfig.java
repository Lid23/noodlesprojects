package com.noodles.springinaction.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.noodles.springinaction.aop.aspects.TrackCounter;
import com.noodles.springinaction.bean.BlankDisc;
import com.noodles.springinaction.bean.CompactDisc;

/**
 * @ClassName: TrackCounterConfig
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 14:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 14:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Aspect
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc compactDisc(){
        BlankDisc compactDisc = new BlankDisc(  );

        compactDisc.setTitle( "久别情歌" );
        compactDisc.setArtist( "张学友" );

        List<String> tracks = new ArrayList<>(  );
        tracks.add( "吻别" );
        tracks.add( "千年等一回" );

        compactDisc.setTracks( tracks );

        return compactDisc;
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }

}
