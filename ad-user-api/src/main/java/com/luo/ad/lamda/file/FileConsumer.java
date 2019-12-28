package com.luo.ad.lamda.file;

@FunctionalInterface
public interface FileConsumer {

    void fileHandler(String fileContent);
}
