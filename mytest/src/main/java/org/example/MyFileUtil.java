package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AbstractFileFilter;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author https://blog.csdn.net/chen_2890
 * @description FileUtil
 * @date 2019/6/14 17:29
 */
public class MyFileUtil {

    public static void main(String[] args) {

        File file = new File("D:\\ziliao\\Shirojc_jb51.rar");

        System.out.println(file.exists());

    }

    @Test
    public  void test5(){
        File s  = new File("D:\\source\\msb\\sourceCode\\spring\\lianpengju\\buildSrc\\src\\main\\java\\org\\springframework\\build\\optional\\OptionalDependenciesPlugin.java");

      boolean isJavaFile =   isJavaFile(s);

        System.out.println(isJavaFile);
    }

   public  static  boolean  isJavaFile (File file){
        String fileName = file.getName();

        String suffixName = getSuffixName(fileName);
       return "java".equals(suffixName);
    }
    public static String getSuffixName(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        //获取文件的后缀名 .jpg
        String suffix = fileName.substring(lastIndexOf+1);

         return suffix;
    }

    /**
     * @param path 文件夹路径
     * @return java.util.List<java.io.File>
     * @description 不使用递归的方法调用
     * @author https://blog.csdn.net/chen_2890
     * @date 2019/6/14 17:34
     * @version V1.0
     */
    public static List<File> traverseFolder(String path) throws Exception {
        List<File> fileList = new ArrayList<>();
        int fileNum = 0, folderNum = 0;
        File destFile = new File(path);
        if (destFile.exists()) {
            LinkedList<File> folderList = new LinkedList<File>();


            if (destFile.isDirectory()) {
                folderList.add(destFile);
            }


            while (!folderList.isEmpty()) {
                File temp_file = folderList.removeFirst();
                File[] files = temp_file.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            System.out.println("文件夹:" + file.getAbsolutePath());
                            folderList.add(file);
                            if (file.getName().indexOf("build") >= 0) {
                                System.out.println("  sssss");
                            }
                            if (("build".equals(file.getName()) || "out".equals(file.getName())) && file.getAbsolutePath().indexOf("buildSrc") < 0) {
                                FileUtils.deleteDirectory(file);
                            }
                            System.out.println("------- fileInFolders.getName() ==" + file.getName());
                            folderNum++;
                        }
//                        else {
//                            fileList.add(file);
//                            System.out.println("文件:" + file.getAbsolutePath());
//                            fileNum++;
//                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
        return fileList;
    }

    /**
     * @param path 文件夹路径
     * @return java.util.List<java.io.File>
     * @description 使用递归的方法调用
     * @author https://blog.csdn.net/chen_2890
     * @date 2019/6/14 17:35
     * @version V1.0
     */
    public static List<File> traverseFolderWithRecursion(String path) {
        List<File> fileList = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return null;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolderWithRecursion(file2.getAbsolutePath());
                    } else {
                        fileList.add(file2);
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        return fileList;
    }

    /**
     * @param path 文件夹路径
     * @return java.util.List<java.io.File>
     * @description 使用递归的方法调用，并判断文件名是否以.jpg结尾
     * @author https://blog.csdn.net/chen_2890
     * @date 2019/6/14 17:35
     * @version V1.0
     */
    public static List<File> getFileList(String path) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(path);
        // 该文件目录下文件全部放入数组
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                // 判断是文件还是文件夹
                if (files[i].isDirectory()) {
                    // 获取文件绝对路径
                    getFileList(files[i].getAbsolutePath());
                    // 判断文件名是否以.jpg结尾
                } else if (fileName.endsWith(".jpg")) {
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    fileList.add(files[i]);
                } else {
                    continue;
                }
            }
        }
        return fileList;
    }

    @Test
    public void test4() {
        File f = new File("D:\\source\\msb\\sourceCode\\spring\\lianpengju");
        Collection<File> c = FileUtils.listFilesAndDirs(f, new MyIOFileFilter(),new MyIOFolderFilter());

        final AtomicInteger javaFileCount = new AtomicInteger(0);
        c.forEach((file) -> {

            if(file.isFile()){
                javaFileCount.incrementAndGet();
                System.out.println(" file  -- " + file.getPath());
            }

        });

        System.out.println(" javaFileCount == " + javaFileCount);


    }

    @Test
    public void test1() throws Exception {
        traverseFolder("D:\\source\\msb\\sourceCode\\spring\\lianpengju");
    }

    @Test
    public void test2() throws Exception {
        File file = new File("D:\\usr\\a");


        FileUtils.deleteDirectory(file);
    }

    @Test
    public void test3() {

        System.out.println("abcd".indexOf("bc"));

    }

    static class MyIOFileFilter extends AbstractFileFilter {

        @Override
        public boolean accept(File file) {
            System.out.println(" MyIOFileFilter accept(File file)  entered");
            boolean isFile = file.isFile();
            boolean isJavaFile = isJavaFile(file);
            if(isJavaFile(file)){
                System.out.println("java file");
            }
            if ( isJavaFile(file)) {
                return true;
            }
            return false;
        }


    }

    static class MyIOFolderFilter  extends AbstractFileFilter {

        @Override
        public boolean accept(File file) {




            return true;
        }


    }
}

