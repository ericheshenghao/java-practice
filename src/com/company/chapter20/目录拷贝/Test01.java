package com.company.chapter20.目录拷贝;

import java.io.*;

public class Test01 {
    public static void main(String[] args) {
        File file = new File("src/com/company/chapter20/目录拷贝");
        copyDir(file, "src/com/company/chapter20/拷贝到");
    }

    public static void copyDir(File f, String des) {
        File desDir = new File(des);
        if (f.isDirectory()) {
            desDir.mkdir();
            File[] files = f.listFiles();
            for (File ff : files
            ) {
                if (!ff.isDirectory()) {
                    Copy(ff, des + "/" + ff.getName());
                } else {
                    copyDir(ff, des + "/" + ff.getName());
                }
            }
        } else {
            System.out.println("请输入正确的路径");
        }
    }

    public static void Copy(File f, String des) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            fis = new FileInputStream(f);

            fos = new FileOutputStream(des);

            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes);
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
