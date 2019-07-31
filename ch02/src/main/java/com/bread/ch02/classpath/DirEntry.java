package com.bread.ch02.classpath;

public class DirEntry implements Entry {

    private String path;

    public DirEntry(String path) {
        this.path = path;
    }

    public byte[] readClass(String className) {
        return new byte[0];
    }
}
