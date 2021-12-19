package com.yu.case19;

import com.yrxy.thread.common.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanglaoxie(微信 : yfct - 8888)
 * @className InterfaceLogDBHandler
 * @description：
 * @date 2017/2/5 10:42
 */
public class InterfaceLogDBHandler {

	public static AtomicInteger integer = new AtomicInteger();
	private static long start;
//    static {
//        start = System.currentTimeMillis();
//    }

	public static int batchSave(List interfaceLogsList) {
		String insertSql = "INSERT INTO interface_log(LOG_NO, SERVER_POOL_NAME, CLIENT_POOL_NAME,client_ip,server_ip, SERVICE_NAME, METHOD_NAME,input_params,output_params, KEYWORD, COST_TIME,EXCEPTION,CREATE_TIME,UPDATE_TIME) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,sysdate(),sysdate())";
		//取得发送sql语句的对象
		PreparedStatement pst = null;
		InterfaceLogModel interfaceLogModel;
		int[] count = new int[0];
		Connection conn = null;
//        long start;
		if (0 == integer.get()) {
			start = System.currentTimeMillis();
		}
		try {
			conn = DataSourceUtils.getConnection();
			pst = conn.prepareStatement(insertSql);

			if (null != interfaceLogsList && interfaceLogsList.size() > 0) {
				for (int i = 0; i < interfaceLogsList.size(); i++) {
					interfaceLogModel = (InterfaceLogModel) interfaceLogsList.get(i);
					pst.setString(1, interfaceLogModel.getLogNo());
					pst.setString(2, interfaceLogModel.getServerPoolName());
					pst.setString(3, interfaceLogModel.getClientPoolName());
					pst.setString(4, interfaceLogModel.getClientIp());
					pst.setString(5, interfaceLogModel.getServerIp());
					pst.setString(6, interfaceLogModel.getServiceName());
					pst.setString(7, interfaceLogModel.getMethodName());
					pst.setString(8, interfaceLogModel.getInputParams());
					pst.setString(9, interfaceLogModel.getOutputParams());
					pst.setString(10, interfaceLogModel.getKeyword());
					pst.setLong(11, interfaceLogModel.getCostTime());
					pst.setString(12, interfaceLogModel.getExcptionPrintInfo());

					//加入批处理
					pst.addBatch();
				}

				count = pst.executeBatch();
//                System.out.println(count.length);
//                System.out.println(" ddd sync data to db, it  has spent " + (System.currentTimeMillis() - start) + "  ms");
			}
			integer.addAndGet(count.length);
			if (Constant.totalRecords == integer.get()) {
				System.out.println("  sync monitor data to db,total records is " + integer.get() + ", it  has spent " + (System.currentTimeMillis() - start) + "  ms");
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
