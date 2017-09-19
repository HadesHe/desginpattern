package com.hzjytech.hades.desginpattern.builderpattern.demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/15.
 */
public class VideoPlayerBuilderTest {


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuilder() throws Exception {
        VideoPlayerBuilder fullVidePlayerBuilder=new FullVideoPlayerBuilder();

        VideoPlay videoPlay=fullVidePlayerBuilder.construct();

        out(videoPlay);

        VideoPlayerBuilder simpleVidePlayerBuilder=new SimpleVideoPlayerBuilder();
        VideoPlay simpleVideoPlayer=simpleVidePlayerBuilder.construct();
        out(simpleVideoPlayer);

        VideoPlayerBuilder memoryPlayerBuilder=new MemoryVideoPlayerBuilder();
        VideoPlay memoryVideoPlayer=memoryPlayerBuilder.construct();
        out(memoryVideoPlayer);

        VideoPlayerBuilder costumPlayerBuilder= new VideoPlayerBuilder() {
            @Override
            protected void buildControlBar() {
                videoPlay.setControlBar("Costom Control Bar");

            }

            @Override
            protected void buildMainWindow() {
                videoPlay.setMainWindow("Costom Main Window");

            }

            @Override
            protected void buildVideoList() {
            }

            @Override
            protected void buildMenu() {
                videoPlay.setMenu("Costum menu");
            }

            @Override
            protected boolean isVideoListShow() {
                return false;
            }
        };
        VideoPlay costumPlayer=costumPlayerBuilder.construct();
        out(costumPlayer);
    }

    private void out(VideoPlay videoPlay) {
        System.out.println(videoPlay.getMenu()+";"+videoPlay.getMainWindow()+";"+videoPlay.getVideoList()+";"+videoPlay.getControlBar());
    }
}