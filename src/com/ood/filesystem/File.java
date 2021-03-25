package com.ood.filesystem;

import java.util.Map;

public class File extends Node {
    // Content store
    String content;

    public File(String name, String owner, String permissions) {
        super(name, owner, permissions);
        content = "";
    }

    @Override
    public void addChild(Node n) throws Exception {
        throw new Exception("Operation not supported");
    }

    @Override
    public void removeChild(Node n) throws Exception {
        throw new Exception("Operation not supported");
    }

    @Override
    public Map<String, Node> getChildren(Node n) throws Exception {
        throw new Exception("Operation not supported");
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
