package com.ood.filesystem;

public class FileSystem {
    Directory root;
    String owner;

    public FileSystem(String owner) {
        this.owner = owner;
        this.root = new Directory("/", owner, "777");
    }

    public void mkdir(String name, String type, String path) {
        // Add a file or director
        //  If path is specified traverse to the last node and create file/dir
        // If path is not specified, create child for root
    }

    public String ls(String path) {
        // List all directories/files
        return null;
    }


    public static void main(String[] args) {
        String owner = "ABC";
        String default_permissions = "644";
        FileSystem fs = new FileSystem("ABC");

    }
}
