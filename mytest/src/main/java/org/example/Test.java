package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

public class Test {

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr+"\n");
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
    @org.junit.Test
    public void test1(){
        String s= readFileContent("D:\\mysource\\mytest\\src\\main\\java\\org\\example\\insert_user10.sql");
        System.out.println(s);
    }
    //private static Logger log = Logger.getLogger(Test.class);

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://192.168.112.151:8066/TESTDB?useSSL=false";
    private static final String USER = "root";
    private static final String PSWD = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PSWD);

            stmt = conn.createStatement();

            //String sql =  readFileContent("D:\\mysource\\mytest\\src\\main\\java\\org\\example\\insert_user10.sql");
         conn.setAutoCommit(false);
          for(int i = 50000;i<500000;i++){
              String sql = "insert into user10(id,name) values(#id#,@@hostname);".replace("#id#",i+"");
          stmt.addBatch(sql);
          }
           stmt.executeBatch();

          conn.commit();

          // stmt.executeBatch();

            int index = 0;
//            while (rs.next()) {
//                index++;
//
//                String id = rs.getString("id");
//                String name = rs.getString("name");
//                String age = rs.getString("age");
//
//
//                String raw = "#{0},{1},{2},{3}";
//                Object[] arr = { index, id, name, age };
//                String outStr = MessageFormat.format(raw, arr);
//                System.out.println(outStr);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("DB/SQL ERROR:" + e.getMessage());
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.print("Can't close stmt/conn because of " + e.getMessage());
            }
            
        }
    }
}