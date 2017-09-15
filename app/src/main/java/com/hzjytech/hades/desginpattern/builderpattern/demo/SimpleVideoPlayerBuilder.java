package com.hzjytech.hades.desginpattern.builderpattern.demo;

/**
 * Created by Hades on 2017/9/15.
 */

public class SimpleVideoPlayerBuilder extends VideoPlayerBuilder {
    @Override
    protected void buildControlBar() {
        videoPlay.setControlBar("Simple Control Bar");
    }

    @Override
    protected void buildMainWindow() {
        videoPlay.setMainWindow("Simple Main Window");

    }

    @Override
    protected void buildVideoList() {

    }

    @Override
    protected void buildMenu() {

    }

    @Override
    protected boolean isVideoListShow() {
        return false;
    }

    @Override
    protected boolean isMenuShow() {
        return false;
    }
}
