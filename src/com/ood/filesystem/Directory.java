package com.ood.filesystem;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Directory extends Node {

    Set<Node> children;

    public Directory(String name, String owner, String permissions) {
        super(name, owner, permissions);
        this.children = new HashSet<>();
    }

    @Override
    public void addChild(Node n) {
        children.add(n);
    }

    @Override
    public void removeChild(Node n) throws Exception {
        if (children.contains(n)) {
            children.remove(n);
        } else {
            throw new Exception("Cannot remove");
        }
    }

    @Override
    public List<Node> getChildren(Node n) {
        return Collections.unmodifiableList((List<Node>) children);
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
