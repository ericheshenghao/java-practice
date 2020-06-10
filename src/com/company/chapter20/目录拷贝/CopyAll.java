package com.company.chapter20.目录拷贝;

import java.io.*;

/*
老师的
 */
public class CopyAll {
    public static void main(String[] args) {
        // 拷贝元
        File srcFile = new File("src/com/company/chapter20/目录拷贝");
        // 拷贝目标
        File destFile = new File("src/com/company/chapter20/拷贝到");
        // 调用方法拷贝
        copyDir(srcFile, destFile);
    }


    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()) {
            // 如果是文件的话，递归结束
            Copy(srcFile, destFile);
            return;
        }
        // 获取源下面的子目录
        File[] files = srcFile.listFiles();
        for (File file : files
        ) {
            // 获取绝对路径
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                // 新建对应的目录
                String srcDir = file.getAbsolutePath();
                String destDir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath()) + "\\" + srcDir.substring(3);
            }
            // 递归调用
            copyDir(file, destFile);
        }
    }

    public static void Copy(File f, File des) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            fis = new FileInputStream(f);

            fos = new FileOutputStream((des.getAbsolutePath().endsWith("\\") ? des.getAbsolutePath() : des.getAbsolutePath()) + "\\" + des.getAbsolutePath().substring(3));

            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, readCount);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}



