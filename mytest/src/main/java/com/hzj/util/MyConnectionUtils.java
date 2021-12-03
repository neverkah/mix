package com.hzj.util;

import com.hzj.entity.Student;
import com.hzj.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MyConnectionUtils {
	//数据库地址
//	    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
//	    private static String user="scott";
//	    private static String password="123456";
		    private static String url="jdbc:mysql://localhost:3306/demotest?useSSL=false&allowPublicKeyRetrieval=true";
	    private static String user="root";
	    private static String password="root";
	    public static Connection conn;
	    
	    public static Connection getConnection() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				conn = DriverManager.getConnection(url, user, password);
				} catch (Exception ex) {
			}
			return conn;
		}  
	    
	  //批量添加
	    public static void batchUpdate(List<Student> list) {
	    	if(conn ==null){
	              conn = getConnection();
	         }
	    	String sql = "insert into student values(?,?,?,?)";
	    	 PreparedStatement pstmt =null;
            try {  
            	 pstmt = conn.prepareStatement(sql);
                conn.setAutoCommit(false);  
                for(int i=0; i<list.size(); i++) {
                	Student infoBean = list.get(i);
                	pstmt.setInt(1, infoBean.getId());
                	pstmt.setString(2,infoBean.getGender());
    	            pstmt.setString(3, infoBean.getName());
					pstmt.setString(4, infoBean.getAdress());

    	        	pstmt.addBatch();  
//    	        	if(i%4000==0){
//   	        		 pstmt.executeBatch(); 
//   	        		 //conn.commit(); //对比：此处加上是否速度有影响（提交后不再同一个事务）;不加速度更快；如果list太大，防止数据库溢出需要加上
//   	        	}
                }  
                // 最后插入不足4000条的数据
                pstmt.executeBatch();  
                conn.commit();  
            } catch (SQLException e) {
                e.printStackTrace();  
                try {  
                    conn.rollback();  
                    conn.setAutoCommit(true);  
                } catch (SQLException e1) {  
                    e1.printStackTrace();  
                }  
            } finally{
            	if(pstmt!=null){
            	try {pstmt.close();} 
                 catch (SQLException e) {e.printStackTrace();}
            	}
            	if(conn!=null){
            		try {
						conn.close();//链接只是关闭，并没有清空
						System.out.println(conn);
						conn = null;//这样关闭，但是如果数据量很大，每次都去链接，会很耗性能，<span style="color:#FF0000;">建议用连接池去管理</span>
					} catch (SQLException e) {
						e.printStackTrace();
					}
            	}
            }
        }



	public static void batchUpdateUser(List<User> list) {
		if(conn ==null){
			conn = getConnection();
		}
		String sql = "insert into user values(?,?,?,?)";
		PreparedStatement pstmt =null;
		try {
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for(int i=0; i<list.size(); i++) {
				User infoBean = list.get(i);
				pstmt.setInt(1, infoBean.getId());
				pstmt.setString(2,infoBean.getName());
				pstmt.setInt(3, infoBean.getAge());
				pstmt.setInt(4, infoBean.getDeptNo());

				pstmt.addBatch();
//    	        	if(i%4000==0){
//   	        		 pstmt.executeBatch();
//   	        		 //conn.commit(); //对比：此处加上是否速度有影响（提交后不再同一个事务）;不加速度更快；如果list太大，防止数据库溢出需要加上
//   	        	}
			}
			// 最后插入不足4000条的数据
			pstmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			if(pstmt!=null){
				try {pstmt.close();}
				catch (SQLException e) {e.printStackTrace();}
			}
			if(conn!=null){
				try {
					conn.close();//链接只是关闭，并没有清空
					System.out.println(conn);
					conn = null;//这样关闭，但是如果数据量很大，每次都去链接，会很耗性能，<span style="color:#FF0000;">建议用连接池去管理</span>
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}