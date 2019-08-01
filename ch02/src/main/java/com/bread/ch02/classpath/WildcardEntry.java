package com.bread.ch02.classpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WildcardEntry implements Entry {

    private List<Entry> entryArr = new ArrayList<>();

    public WildcardEntry(String path) {
        String baseDir = path.substring(0, path.length() - 1);
        File file = new File(baseDir);
        File[] files = file.listFiles();
        for (File info : files) {
            if (info.getName().endsWith(".jar") || info.getName().endsWith(".JAR")) {
                String filePath = info.getPath();
                entryArr.add(EntryFactory.newEntry(filePath));
            }
        }
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        for (Entry entry : entryArr) {
            try {
                return entry.readClass(className);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new FileNotFoundException("File '" + className + "' does not exist");
    }
}
