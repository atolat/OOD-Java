package com.ood.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    Directory root;
    String owner;

    public FileSystem(String owner) {
        this.owner = owner;
        this.root = new Directory("/", owner, "644");
    }

    public void mkdir(String path) {
        // Add directory
        String[] dirs = path.split("/");
        Node curr = root;
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                Node n = new Directory(dir, owner, "644");
                curr.children.put(dir, n);
            }
            curr = curr.children.get(dir);
        }
    }

    public void touch(String path) {
        // Add file
        String[] dirs = path.split("/");
        Node curr = root;
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                Node n = new File(dir, owner, "644");
                curr.children.put(dir, n);
            }
            curr = curr.children.get(dir);
        }
    }

    public void touch(String path, String content) throws Exception {
        // Write to file
        String[] dirs = path.split("/");
        Node curr = root;
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                Node n = new File(dir, owner, "644");
                curr.children.put(dir, n);
            }
            curr = curr.children.get(dir);
        }
        curr.StreamIn(content);
    }

    public String less(String path) throws Exception {
        String[] dirs = path.split("/");
        Node curr = root;
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                System.out.println("Invalid Path");
            }
            curr = curr.children.get(dir);
        }
        return curr.StreamOut();
    }

    public void recursiveTraverse(Node node) {
        System.out.println(node);
        // base
        if (node.children == null) {
            return;
        }
        for (Node n : node.children.values()) {
            recursiveTraverse(n);
        }
    }

    public List<String> ls(String path) {
        // List all directories/files
        String[] dirs = path.split("/");
        Node curr = root;
        List<String> result = new ArrayList<>();
        String name = "";
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                return result;
            }
            curr = curr.children.get(dir);
        }
        for (String key : curr.children.keySet()) {
            result.add(key);
        }
        return result;
    }


    public static void main(String[] args) {
        String owner = "ABC";
        String default_permissions = "644";
        FileSystem fs = new FileSystem("ABC");

        fs.mkdir("/a/b/c");
        fs.touch("/a/b/test.txt");
        try {
            fs.touch("/a/b/test1.txt", "Add content...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(fs.ls("/a/b"));
        try {
            System.out.println(fs.less("/a/b/test1.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fs.recursiveTraverse(fs.root);
    }
}
