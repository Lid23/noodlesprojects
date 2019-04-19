package com.noodles.springinaction.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TrackCounter
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 13:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 13:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>(  );

    @Pointcut("execution(* noodles.springaction.bean.CompactDisc.playTrack(int))" + "&& args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Before( "trackPlayed(trackNumber)" )
    public void countTrack(int trackNumber){
        int currentCount = getPlayCount( trackNumber );
        trackCounts.put( trackNumber, currentCount + 1 );
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey( trackNumber ) ? trackCounts.get( trackNumber ) : 0;
    }


}
