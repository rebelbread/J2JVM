package com.bread.ch02.classpath;



public class EntryFactory {

    public static final String pathListSeparator = ";";

    private EntryFactory() {
    }

    public static Entry newEntry(String path){
        if (path.contains(pathListSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar") || path.equals(".JAR") ||
            path.equals(".zip") || path.equals(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);

    }

}
