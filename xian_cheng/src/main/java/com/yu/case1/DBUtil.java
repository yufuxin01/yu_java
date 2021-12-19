package com.yu.case1;

import java.sql.*;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className DBUTil
 * @description：
 * @date 2017/11/26 11:58
 */
public class DBUtil {

    //连接地址
//    private static String URL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static String URL="jdbc:mysql://8.140.107.38:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    //导入的驱动连接包中驱动的名称 jdbc:mysql://8.140.107.38:3306/
    private static String DRIVER="com.mysql.jdbc.Driver";

    //数据库用户名
    private static String USER="root";
    //数据库密码
    private static String PASSWORD="123456";

    public static Connection conn;

  public static synchronized  Connection  getConn() {
        if(null!=conn){
//            System.out.println("conn  is not  null");
            return conn;
        }
      //利用静态代码块来加载驱动信息
      try {
          Class.forName(DRIVER);
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
      try {
        //  利用DriverManager.getConnection()方法获取到连接对象
          conn= DriverManager.getConnection(URL,USER,PASSWORD);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      try {
          conn.setAutoCommit(true);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return  conn;
  }


}
