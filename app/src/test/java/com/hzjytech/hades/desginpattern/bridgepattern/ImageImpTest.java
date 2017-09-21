package com.hzjytech.hades.desginpattern.bridgepattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/21.
 */
public class ImageImpTest {

    @Test
    public void testImageImp() throws Exception {
        Image bmpImage = new BMPImage();
        bmpImage.setImp(new LinuxImp());
        bmpImage.parseFile("small bro");

        bmpImage.setImp(new UnixImp());
        bmpImage.parseFile("small bro");

        bmpImage.setImp(new WindowsImp());
        bmpImage.parseFile("small bro");


        Image gifImage = new GIFImage();
        gifImage.setImp(new LinuxImp());
        gifImage.parseFile("small bro");

        gifImage.setImp(new UnixImp());
        gifImage.parseFile("small bro");

        gifImage.setImp(new WindowsImp());
        gifImage.parseFile("small bro");

        Image jpgImage = new JPGImage();
        jpgImage.setImp(new LinuxImp());
        jpgImage.parseFile("small bro");

        jpgImage.setImp(new UnixImp());
        jpgImage.parseFile("small bro");

        jpgImage.setImp(new WindowsImp());
        jpgImage.parseFile("small bro");

        Image pngImage = new PNGImage();
        pngImage.setImp(new LinuxImp());
        pngImage.parseFile("small bro");

        pngImage.setImp(new UnixImp());
        pngImage.parseFile("small bro");

        pngImage.setImp(new WindowsImp());
        pngImage.parseFile("small bro");





    }
}