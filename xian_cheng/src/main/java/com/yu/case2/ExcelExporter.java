package com.yu.case2;

import com.yrxy.thread.common.PageHelper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcelExporter {

	public static void main(String[] args) {
		createExcelFile();
	}

	public static void createExcelFile() {
		ExecutorService pool = Executors.newFixedThreadPool(100);

		//获取总条数
		int count = UserHandler.queryCount();

	    // 获取总页数
		final int totalPageCount = PageHelper.getTotalPageCount(count);
		String tableName = "user";

		final long start = System.currentTimeMillis();
		for (int currentPageNum = 0; currentPageNum < totalPageCount; currentPageNum++) {

			String pageSql = PageHelper.getPageSql(tableName, currentPageNum);

			final List userList = UserHandler.queryUserList(pageSql);
			final int finalCurrentPageNum = currentPageNum;
			Runnable run = () -> {
				ExcelUtil.CreateExcel(finalCurrentPageNum, userList);
				if (finalCurrentPageNum == (totalPageCount - 1)) {
					System.out.println("  export data to excel, it  has spent " + (System.currentTimeMillis() - start) + "  ms");
				}
			};
			pool.execute(run);

		}
	}


}
