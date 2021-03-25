package com.ood.filesystem;

import java.util.HashMap;
import java.util.Map;

public class Directory extends Node {

    public Directory(String name, String owner, String permissions) {
        super(name, owner, permissions);
        this.children = new HashMap<>();
    }

    @Override
    public void addChild(Node n) {
        children.put(name, n);
    }

    @Override
    public void removeChild(Node n) throws Exception {
        if (children.containsKey(n.name)) {
            children.remove(n.name);
        } else {
            throw new Exception("Cannot remove");
        }
    }

    @Override
    public Map<String, Node> getChildren(Node n) {
        return children;
    }

    @Override
    public void StreamIn(String s) throws Exception {
        throw new Exception("Operation not Supported");
    }

    @Override
    public String StreamOut() throws Exception {
        throw new Exception("Operation not Supported");
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                '}';
    }
}
