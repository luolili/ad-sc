package com.luo.ad.lamda.file;

import org.junit.Test;

public class FileServiceTest {

    @Test
    public void test() throws Exception {
        FileService fileService = new FileService();
        String url = "F:\\githubpro\\ad-sc\\ad-user-api\\src\\test\\java\\com\\luo\\ad\\lamda\\file\\FileServiceTest.java";
        fileService.fileHandle(url, fileContent -> {
            //
            System.out.println(fileContent);
        });

    }
}
