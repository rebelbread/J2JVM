package com.bread.ch02.classpath;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipEntry implements Entry {

    private String path;

    public ZipEntry(String path) {
        File file = new File(path);
        if (file.exists()) {
            this.path = path;
        }
        throw new RuntimeException("文件不存在");

    }

    @Override
    public byte[] readClass(String className) throws Exception {
        return readZipFile(className);
    }

    private byte[] readZipFile(String file) throws Exception {
        ZipFile zf = new ZipFile(path);
        InputStream in = new BufferedInputStream(new FileInputStream(path));
        ZipInputStream zin = new ZipInputStream(in);
        java.util.zip.ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            if (!ze.isDirectory()) {
                if (ze.getName().equals(file)) {
                    InputStream inputStream = zf.getInputStream(ze);
                    return IOUtils.readFully(inputStream, (int) ze.getSize());
                }
            }
        }
        zin.closeEntry();
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }
}
