package com.ood.filesystem;

import java.util.List;

public class File extends Node {
    // Content store
    String content;

    public File(String name, String owner, String permissions) {
        super(name, owner, permissions);
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
    public List<Node> getChildren(Node n) throws Exception {
        throw new Exception("Operation not supported");
    }

    @Override
    public void StreamIn(String s) {
        content.concat(s);
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
