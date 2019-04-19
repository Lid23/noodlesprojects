package com.noodles.springinaction.bean;

import java.util.List;

/**
 * @ClassName: BlankDisc
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/18 9:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/18 9:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BlankDisc implements CompactDisc {

    private String title;

    private String artist;

    private List<String> tracks;

    public BlankDisc(){};

    public BlankDisc(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int trackNumber) {
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

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
