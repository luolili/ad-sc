package com.luo.ad.lamda.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileService {

    public void fileHandle(String url, FileConsumer fileConsumer) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(url))));


        String line;
        StringBuffer sb = new StringBuffer();

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\n");
        }
        //处理文件内容
        fileConsumer.fileHandler(sb.toString());

    }

}
