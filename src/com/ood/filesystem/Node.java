package com.ood.filesystem;

import java.util.Map;

public abstract class Node {
    // Unify all methods common to files and directories
    public static int idCounter;
    int id;
    String name;
    String owner;
    String permissions;
    Map<String, Node> children;

    public Node(String name, String owner, String permissions) {
        this.id = ++idCounter;
        this.name = name;
        this.owner = owner;
        this.permissions = permissions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    // File Specific Methods
    public abstract void StreamIn(String s) throws Exception;

    public abstract String StreamOut() throws Exception;

}
