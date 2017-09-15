package com.hzjytech.hades.desginpattern.builderpattern.demo;

/**
 * Created by Hades on 2017/9/15.
 */

public class MemoryVideoPlayerBuilder extends VideoPlayerBuilder {
    @Override
    protected void buildControlBar() {
        videoPlay.setControlBar("Memory Control Bar");
    }

    @Override
    protected void buildMainWindow() {
        videoPlay.setMainWindow("Memory Main Window");

    }

    @Override
    protected void buildVideoList() {
        videoPlay.setVideoList("Memory Video List");

    }

    @Override
    protected void buildMenu() {

    }

    @Override
    protected boolean isMenuShow() {
        return false;
    }
}
