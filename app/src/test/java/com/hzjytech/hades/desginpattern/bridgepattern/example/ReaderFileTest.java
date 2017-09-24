package com.hzjytech.hades.desginpattern.bridgepattern.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/9/24.
 */
public class ReaderFileTest {

    @Test
    public void testBridge() throws Exception{

        ReaderFile txtReaderFile=new TxtReader();
        txtReaderFile.setmDatasetReader(new OracleReader());
        txtReaderFile.typeChange();
        txtReaderFile.setmDatasetReader(new DB2Reader());
        txtReaderFile.typeChange();
        txtReaderFile.setmDatasetReader(new MySQLReader());
        txtReaderFile.typeChange();

        ReaderFile pdfReader=new PdfReader();
        pdfReader.setmDatasetReader(new OracleReader());
        pdfReader.typeChange();
        pdfReader.setmDatasetReader(new DB2Reader());
        pdfReader.typeChange();
        pdfReader.setmDatasetReader(new MySQLReader());
        pdfReader.typeChange();

        ReaderFile xmlReader=new XmlReader();
        xmlReader.setmDatasetReader(new OracleReader());
        xmlReader.typeChange();
        xmlReader.setmDatasetReader(new DB2Reader());
        xmlReader.typeChange();
        xmlReader.setmDatasetReader(new MySQLReader());
        xmlReader.typeChange();





    }

}