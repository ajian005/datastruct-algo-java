package com.data.struct.basic.file;

import java.io.File;

/**
 * 打印文件夹结构
 * root/
 * ├── file1.txt
 * ├── dir1/
 * │   ├── file2.txt
 * │   └── dir2/
 * │       └── file3.txt
 * └── dir3/
 */
public class DirectoryTreePrinter2 {
    public static void main(String[] args) {
        // 设定要遍历的目录路径，默认为当前目录
        String rootPath = ".";
        File root = new File(rootPath);

        if (root.exists() && root.isDirectory()) {
            printDirectoryTree(root, 0);
        } else {
            System.out.println("目录不存在或不是一个有效的目录");
        }
    }

    public static void printDirectoryTree(File file, int depth) {
        // 打印缩进格式
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        // 打印当前文件/文件夹名称
        System.out.println("|—— " + file.getName());

        // 如果是目录，则递归遍历其子文件/子目录
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printDirectoryTree(f, depth + 1);
                }
            }
        }
    }
}
