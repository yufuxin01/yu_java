package com.yu.case1;

import com.yrxy.thread.common.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author huanglaoxie(微信 : yfct - 8888)
 * @className UserBatchHandler2
 * @description：
 * @date 2017/11/27 13:10
 */
public class UserBatchHandler {


    public static int batchSave(List<User> userList, String threadName) {
        String insertSql = "INSERT INTO user(id,name,createdTime,updatedTime) VALUES(?,?,sysdate(),sysdate())";
        //取得发送sql语句的对象
        PreparedStatement pst = null;
        User user;
        int[] count = new int[0];
        Connection conn = null;
        try {
            conn = DataSourceUtils.getConnection();
            pst = conn.prepareStatement(insertSql);

            long start = System.currentTimeMillis();
            if (null != userList && userList.size() > 0) {
                for (int i = 0; i < userList.size(); i++) {
                    user = userList.get(i);
                    pst.setInt(1, user.getId());
                    pst.setString(2, user.getName());
                    //加入批处理
                    pst.addBatch();
                }

                count = pst.executeBatch();
                System.out.println(count.length);
                System.out.println(" threadName为" + threadName + ", sync data to db, it  has spent " + (System.currentTimeMillis() - start) + "  ms");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4. 释放资源
            DataSourceUtils.close(conn, pst);
        }

        //获取到数据更新的行数
        return count.length;
    }
}
