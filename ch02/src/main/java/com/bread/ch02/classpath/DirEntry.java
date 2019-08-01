package com.bread.ch02.classpath;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DirEntry implements Entry {

    private String path;

    public DirEntry(String path) {
        File file = new File(path);
        if (file.exists()) {
            this.path = path;
        }
        throw new RuntimeException("文件不存在");
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        String fileName = path + File.separator + className;
        return FileUtils.readFileToByteArray(new File(fileName));
    }

    @Override
    public String toString() {
        return "DirEntry{" +
                "path='" + path + '\'' +
                '}';
    }
}
