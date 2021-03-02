package com.hzj;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.*;

/**
 * @aothor 果冻
 * @date 2020-05-21 21:36
 * 注：将所有jar包转成pom.xml文件中的依赖配置
 */
public class JarToPom {


    public static void main(String[] args) throws FileNotFoundException, IOException {

        String libpath = "E:\\kjyq\\imps\\web\\WEB-INF\\lib";//jar包所在的文件夹路径
        String outpath = "E:\\kjyq\\imps\\web\\WEB-INF\\lib\\dependicy.txt";//输出maven依赖配置的路径
        //创建jar包所在的文件夹对象
        File lib = new File(libpath);
        //遍历文件夹中的jar包
        for (File jar : lib.listFiles()) {
            try {
                getPomXml(outpath, jar);
            } catch (Exception e) {
                System.out.println("failed transformed file "+ jar.getName());
                e.printStackTrace();
            }


        }
    }

    private static void getPomXml(String outpath, File jar) throws IOException {
        //获取jar包文件名称,如    mysql-connector-java-5.1.8.jar
        String jarName = jar.getName();
        int index = jarName.lastIndexOf("-");
        int jarIndex = jarName.lastIndexOf(".");

        String bundleName = jarName.substring(0, index);//得到mysql-connector-java
        String bundleVersion = jarName.substring(index + 1, jarIndex);//得到5.1.8

        if (bundleName == null || bundleVersion == null) {
            return;
        }

        /*  举例：  <!-- mysql-connector-java-5.1.38.jar -->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>5.1.38</version>
                </dependency>
        */

        String dependices = getDependices(bundleName, bundleVersion) + "\r\n";

        BufferedWriter bw = new BufferedWriter(new FileWriter(outpath, true));

        bw.write(dependices);
        bw.newLine();

        bw.flush();
        bw.close();
        System.out.println(bundleName + "已完成");
    }


    public static String getDependices(String key, String ver) {
        //建立连接网址
        String url = "https://mvnrepository.com/search?q=" + key;

        //定义变量前端页面对象document
        Document doc = null;
        try {
            //访问中央仓库
            Connection header = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            //设置超时时间8秒
            header.timeout(8000);
            //使用get请求获取前端页面document
            doc = header.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取body，进行解析页面
        Element elem = doc.body();
        Node node = elem.childNodes().get(1).childNodes().get(2).childNodes().get(2).childNodes().get(0);
        Attributes attributes = node.attributes();
        //得到最终数据
        String href = attributes.get("href");
        String[] jarinfo = href.split("/");

        String result = "<dependency>\r\n" +
                "    <groupId>" + jarinfo[2] + "</groupId>\r\n" +
                "    <artifactId>" + key + "</artifactId>\r\n" +
                "    <version>" + ver + "</version>\r\n" +
                "</dependency>";
        return result;
    }
}
 
 
 
 