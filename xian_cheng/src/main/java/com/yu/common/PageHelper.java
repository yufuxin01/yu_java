package com.yu.common;

/**
 * Filename: PageHelper.java
 * 
 * @function:分页对象，用作数据的批量处理
 */

public class PageHelper {

//    public static final int pageSize = 100000;
      public static final int pageSize = 10000;

    private int currentPageNum;
    private int lastPageNum;
    private int totalRecordCount;

    public static void main(String[] args) {
        String tableName="user";
        int index=1;
        long currentPageNum=0;
        String pageSql=PageHelper.getPageSql( tableName,  currentPageNum);
        System.out.println("  pageSql  is  : "+pageSql);

    }

    /**
     *获取总页数
     * @param totalRecordCount 总条数
     * @return 总页数
     */
    public static int getTotalPageCount(int totalRecordCount) {
        if (totalRecordCount == 0) {
            return 0;
        }

        int lastPageCount = totalRecordCount % pageSize;
        int totalPageCount;
        if (lastPageCount > 0) {
            // 如果 余数大于零的话
            totalPageCount = totalRecordCount / pageSize + 1;
        } else {
            //如果余数为零的话
            totalPageCount = totalRecordCount / pageSize;
        }
        return totalPageCount;
    }


    /**
     *拼接查询sql,根据id偏移量进行查询的
     * @param currentPageNum 当前页数-1
     * @return sql
     */
    public static String getPageSql(String tableName,long currentPageNum){

        return "select * from "+ tableName +
                " where id>=" +(1+(currentPageNum * pageSize)) +
                " and id<="+(currentPageNum+1) * pageSize;
    }


    /**
     * 
     * @param tableName
     * @param updateTimeLabel
     * @param lastMaxUpdateTime
     * @param interval
     * @param currentPageNum
     * @param lastPageNum
     * @return
     */
    public String getPageSql(String tableName, String updateTimeLabel, String lastMaxUpdateTime, String interval, int currentPageNum, int lastPageNum) {
        String pageSql;
        if (lastMaxUpdateTime.indexOf(Constants.sysdate) != -1) {
            pageSql = "select * from(select rownum AS rowno, a.* from " + tableName + " a where " + updateTimeLabel + " >=" + lastMaxUpdateTime + "-" + interval + " and rownum <=" + currentPageNum * pageSize + " order by "+updateTimeLabel+ " ) b where b.rowno >" + lastPageNum * pageSize;

        } else {
            pageSql = "select * from(select rownum AS rowno, a.* from " + tableName + " a where " + updateTimeLabel + ">=to_date('" + lastMaxUpdateTime + "','yyyy-MM-dd HH24:mi:ss')" + "-" + interval + " and rownum <=" + currentPageNum * pageSize + " order by "+updateTimeLabel+  ") b where b.rowno >" + lastPageNum * pageSize;

        }
        return pageSql;
    }

    /**
     * 
     * @param basicSql
     * @return
     */
    public String getTotalRecordsCountSql(String basicSql) {
        String totalRecordsCountSql = "select count(*) from " + "(" + basicSql + ")";
        return totalRecordsCountSql;
    }

    /**
     * 
     * @param tableName
     * @param updateTimeKey
     * @param updateTimeLable
     * @param lastMaxUpdateTime
     * @param interval
     * @return
     */
    public String buildDynamicSyncSql(String tableName, String updateTimeKey, String updateTimeLable, String lastMaxUpdateTime, String interval) {
        String sql;
        if (lastMaxUpdateTime.indexOf(Constants.sysdate) != -1) {
            sql = "SELECT  * FROM  " + tableName + "   where " + updateTimeLable + ">=" + lastMaxUpdateTime + "-" + interval;
        } else {
            sql = "SELECT  * FROM  " + tableName + "   where " + updateTimeLable + ">=to_date('" + lastMaxUpdateTime + "','yyyy-MM-dd HH24:mi:ss')" + "-" + interval;
        }

        return sql;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getLastPageNum() {
        return lastPageNum;
    }

    public void setLastPageNum(int lastPageNum) {
        this.lastPageNum = lastPageNum;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public static int getPagesize() {
        return pageSize;
    }



}
