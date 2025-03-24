package com.data.struct.basic.file;

import java.io.File;
import java.util.List;

/**
 * 问题 以当前项目文件夹为基准，打印输出树形结构
 * 如:      root
 *        /    \
 *      left    right
 * 树的遍历
 */
public class PrintLinuxDirTree {
    public static void main(String[] args) {
        PrintLinuxDirTree obj = new PrintLinuxDirTree();
        obj.testPrintLinxuDir("/Users/lijianquan/workspace/datastruct-algo/datastruct-algo-java/src/main/java/com/data/struct/basic");
    }

    public void testPrintLinxuDir(String path) {
        System.out.println("path=" + path);
        File file  = new File(path);
        printCurrentFile(file);
    }

    public void printCurrentFile(File file) {
        if (!file.exists()) {
            return;
        }
        File[] files   = file.listFiles();
        if (files != null && files.length > 0) {
            for (File fileTemp : files) {
                System.out.println(fileTemp.getName());
                printCurrentFile(fileTemp);
            }
            System.out.println("");
            //System.out.println("xxx");
        }
    }

}