package com.brianway.learning.java.guava.io;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;
import org.junit.Test;

/**
 * FileTest
 *
 * @author lengbing
 * @version 1.0
 * @date 2018/4/24 下午12:24
 * @since 1.8
 */
public class FileTest {
    @Test
    public void FileWriterTest(){
        String fileName = "";

        try
        {
            File newFile = new File(fileName);
            Files.write("".getBytes(), newFile);

        }
        catch (IOException fileIoEx)
        {
            System.err.println(  "ERROR trying to write to file '" + fileName + "' - "
                + fileIoEx.toString());
        }

    }


}
