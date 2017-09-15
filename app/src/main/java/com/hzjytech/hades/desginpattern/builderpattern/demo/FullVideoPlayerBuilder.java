package com.hzjytech.hades.desginpattern.builderpattern.demo;

/**
 * Created by Hades on 2017/9/15.
 */

public class FullVideoPlayerBuilder extends VideoPlayerBuilder {
    @Override
    protected void buildControlBar() {
        videoPlay.setControlBar("Full ControlBar");

    }

    @Override
    protected void buildMainWindow() {
        videoPlay.setMainWindow("Full MainWindow");

    }

    @Override
    protected void buildVideoList() {
        videoPlay.setVideoList("Full VideoList");

    }

    @Override
    protected void buildMenu() {
        videoPlay.setMenu("Full Menu");

    }
}
