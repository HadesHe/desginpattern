package com.hzjytech.hades.desginpattern.builderpattern.demo;

/**
 * Created by Hades on 2017/9/15.
 */

public abstract class VideoPlayerBuilder {

    protected VideoPlay videoPlay=new VideoPlay();

    protected VideoPlay construct(){
        if(isMenuShow()) {
            buildMenu();
        }
        if(isVideoListShow()) {
            buildVideoList();
        }
        buildMainWindow();
        buildControlBar();

        return videoPlay;
    }

    protected boolean isVideoListShow() {
        return true;
    }

    protected boolean isMenuShow() {
        return true;
    }

    protected abstract void buildControlBar();

    protected abstract void buildMainWindow();

    protected abstract void buildVideoList();

    protected abstract void buildMenu();
}
