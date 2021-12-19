package com.yu.common;

/**
 * Filename: Constant.java
 * 
 * @Copyright: Copyright (c)2018
 * @Company: jd
 * @author: huanglaoxie
 * @function:
 * @version: 1.0
 * @Create at: 2016年8月3日 上午11:10:47
 */
public interface Constants {

    public final static String delemiter = "\\";
    public final static String starDelemiter = "\\*";
    public final static String tableName = "tableName";
    public final static String tribeName = "tribeName";
    public final static String primaryKey = "primaryKey";

    public final static String updateTimeLable = "updateTimeLable";
    public final static String updateTimeValue = "updateTimeValue";

    public final static String head = "head";
    public final static String body = "body";
    public final static String batchMsgId="batchMsgId";
    
    // 表结构的列名称
    public final static String columnNames = "columnNames";
    // 插入的记录集合
    public final static String insertRecords = "insertRecords";
    // 更新的记录集合
    public final static String updateRecords = "updateRecords";
    
    public static final int distrLockBatchSize = 2000;
    
    public final static String sysdate = "sysdate";
    
    //public final static String yesterday = "sysdate-3";
    
    //如果从缓存获取远程业务表结构的最大更新时间（比如：上线后第一次同步数据），则设置该表结构的最大更新时间为该业务数据库系统时间的前10分钟为最大更新时间
    public final static String defaultRemoteTableMaxUpdateTime="sysdate";
    
//    public final static String defaultRemoteTableMaxUpdateTime="sysdate";
    public final static String oracleDriver = "oracle.jdbc.OracleDriver";
    public final static String validKey="1";
    public final static String updateKey="update";
    public final static String tableValidStatus="1";
    
    
    public final static String singleRecordPrefix="singleRecord";
    
    //redis分布式锁的前缀
    public final static String redisTableLockKeyPrefix="tableLock";
    
    //redis批量分布式锁的前缀
    public final static String redisBatchDistrLockKeyPrefix="BatchLock";
    
    //redis更新时间key值的前缀
    public final static String redisUpdateTimeKeyPrefix="UTime103";
    //主键的前缀、后缀
    public final static String pkPrefix="pkPrefix185";
    public final static String pkEndfix="pkEndfix";
    
    public final static String upTimePrefix="upTimePrefix";
    public final static String upTimeEndfix="upTimeEndfix";
    
    public final static String bizTablesConfList="bizTablesConfList88";
    
}
