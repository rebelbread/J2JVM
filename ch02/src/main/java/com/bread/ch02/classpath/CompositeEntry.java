package com.bread.ch02.classpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CompositeEntry implements Entry {

    private List<Entry> entryArr = new ArrayList<>();

    public CompositeEntry(String path) {
        String[] paths = path.split(File.pathSeparator);
        for (String entryPath : paths) {
            Entry entry = EntryFactory.newEntry(entryPath);
            entryArr.add(entry);
        }
    }

    @Override
    public byte[] readClass(String className) throws FileNotFoundException {
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
