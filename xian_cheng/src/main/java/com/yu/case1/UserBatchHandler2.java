package com.yu.case1;

import java.sql.*;
import java.util.List;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @date 2017/11/25 17:23
 */
public class UserBatchHandler2 {


    public static void main(String[] args) throws SQLException {
        //利用DriverManager.getConnection()方法获取到连接对象


//        PreparedStatement pst = batchSave();


//        query(conn, pst);


    }

    public static void query(Connection conn, PreparedStatement pst) {
        String sql = "SELECT *  from user";
        try {
            PreparedStatement pst2 = conn.prepareStatement(sql);
            ResultSet rst= pst2.executeQuery();
            while(rst.next()) {
                System.out.println("id:"+rst.getObject("id")+" 姓名:"+rst.getObject("name"));
               }
            rst.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static int batchSave(List userList) throws SQLException {

        String insertSql ="INSERT INTO user(id,name,createdTime,updatedTime) VALUES(?,?,sysdate(),sysdate())";
        //取得发送sql语句的对象
        PreparedStatement pst = DBUtil.getConn().prepareStatement(insertSql);
        User  user;
        int[] count = new int[0];
        long start=System.currentTimeMillis();
        if(null!=userList&&userList.size()>0){
            for(int i=0;i<userList.size();i++){
                user= (User) userList.get(i);
                pst.setInt(1,user.getId());
                pst.setString(2,user.getName());
                //加入批处理
                pst.addBatch();
            }

            count= pst.executeBatch();
            System.out.println(count.length);
            System.out.println(" ddd sync data to db, it  has spent " +(System.currentTimeMillis()-start)+"  ms");

        }

        //获取到数据更新的行数
//        int a = pst.executeUpdate();
//        System.out.println(a);
        return count.length;
    }


}
