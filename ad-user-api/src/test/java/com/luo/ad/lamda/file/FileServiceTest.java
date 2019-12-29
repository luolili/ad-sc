package com.luo.ad.lamda.file;

import lombok.val;
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

    //@RequiredArgsConstructor:final ,有验证的字段
    @Test
    public void testVal() {
        val s = "sh";
        System.out.println(s);
    }
}
