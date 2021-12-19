package com.yu.case19;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * Filename:     InterfaceLogHandler.java 
 * @Copyright:   Copyright (c)2016 
 * @Company:     jd 
 * @author:      huanglaoxie
 * @function:    异步、并发、批量保存接口日志
 * @version:     1.0 
 * @Create at:   2016年9月18日 下午2:24:00 
 */
public class InterfaceLogHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(InterfaceLogHandler.class);
	//revMsgQueue是异步接受日志的队列
	private static final LinkedBlockingQueue<InterfaceLogModel> revMsgQueue = new LinkedBlockingQueue<InterfaceLogModel>();
	// 单例对象
	private static InterfaceLogHandler logHandler;
    private InterfaceLogHandler() {
    }

    public static synchronized InterfaceLogHandler getInterfaceLogHandlerInstance() {
        if (null == logHandler) {
            logHandler = new InterfaceLogHandler();
            // 启动消费线程
            new ComsumerTask().start();
        }
        return logHandler;
    }
    
	/**
	 * @Title:handleLogReq
	 * @Description:异步并发批量保存接口日志的入口方法
	 * @param interfaceLog
	 * @return 
	 * @Return:void
	 */
    public void handleLogReq(InterfaceLogModel interfaceLog) {
        //如果接受队列的对象数没有达到临界值，则把新的对象装载到接受队列
        revMsgQueue.add(interfaceLog);
    }
    
    private static class ComsumerTask extends Thread {
        private static InterfaceLogDBHandler InterfaceLogDBHandler=new InterfaceLogDBHandler();
        @Override
		public void run() {
            try {
                while(true) {
                    try {
                        // 遍历Queue，保存日志记录
                        List<InterfaceLogModel> list = new ArrayList<InterfaceLogModel>();
                        InterfaceLogModel model = null;
                        while((model = revMsgQueue.poll()) != null) {
                            list.add(model);
                            // 100个一批保存
                            if(list.size() >= Constant.handleQueueBatchCount) {
                                System.out.println("list.size() >= Constant.handleQueueBatchCount");
                                // 触发保存行为
                                InterfaceLogDBHandler.batchSave(list);
                                list.clear();
                            }
                        }
                        
                        if(list.size() > 0) {
                            System.out.println("list.size() > 0");
                            // 触发保存行为
                            InterfaceLogDBHandler.batchSave(list);
                            list.clear();
                        }
                    } catch(Exception e1) {
                        logger.error("save logs error", e1);
                    }
                    // 睡眠1s后执行
//                    Thread.sleep(1000);
                    Thread.sleep(10);
                }
            }
            catch (Exception e) {
                logger.error("timer thread error", e);
            }
        }
    }
}
