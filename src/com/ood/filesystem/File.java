package com.ood.filesystem;

public class File extends Node {
    // Content store
    String content;

    public File(String name, String owner, String permissions) {
        super(name, owner, permissions);
        content = "";
    }

    @Override
    public void StreamIn(String s) {
        content += s;
    }

    @Override
    public String StreamOut() {
        return content;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                '}';
    }
}
