package com.noodles.springinaction.bean;

import org.springframework.stereotype.Component;

/**
 * @ClassName: SgtPeppers
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/17 8:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 8:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
//组件扫描的bean命名
//@Component("")
//Component的替代方案
//@Named
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt.Pepper's Lonely Hearts Club Bank";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public  void playTrack(int trackNumber){
        System.out.println("play track " + trackNumber);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
