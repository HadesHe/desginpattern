package com.hzjytech.hades.desginpattern.templatepattern.templemethod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/11/24.
 */
public class DataViewerTest {

    @Test
    public void testDataView() throws Exception {
        DataViewer dataViewer=new XmlDataView();
        dataViewer.process();
    }
}