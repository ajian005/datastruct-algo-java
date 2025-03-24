package com.data.struct.basic.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryTreePrinter extends SimpleFileVisitor<Path> {

    private int level = 0;

    public static void main(String[] args) {
        Path startingDir = Paths.get(".");
        try {
            Files.walkFileTree(startingDir, new DirectoryTreePrinter());
        } catch (IOException e) {
            System.err.println("Error accessing file tree: " + e.getMessage());
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        printIndent();
        if (!dir.equals(Paths.get("."))) {
            System.out.println(dir.getFileName());
        }
        level++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        printIndent();
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        level--;
        return FileVisitResult.CONTINUE;
    }

    private void printIndent() {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
    }
}
