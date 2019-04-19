package com.noodles.springinaction.bean;

/**
 * @ClassName: CompactDisc
 * @Description: CD播放器
 * @Author: Sal
 * @CreateDate: 2018/5/17 8:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 8:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface CompactDisc {

    /*
    * @Author: Sal
    * @Description:
    * @Date:2018/5/17 8:47
    */
    void play();

    void playTrack(int trackNumber);


}
