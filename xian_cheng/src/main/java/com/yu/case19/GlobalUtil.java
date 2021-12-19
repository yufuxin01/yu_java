package com.yu.case19;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * Filename:     GlobalUtil.java 
 * @Copyright:   Copyright (c)2016 
 * @Company:     jd 
 * @author:      huanglaoxie
 * @function:    全局日志的工具类
 * @version:     1.0 
 * @Create at:   2016年9月19日 下午2:20:01 
 */
public class GlobalUtil {
	
    private static final Logger logger = LoggerFactory.getLogger(GlobalUtil.class);

    private static ThreadLocal<String> threadlocal = new ThreadLocal<String>();
    
    private static Integer index = 0;  // 当前的序号

    private static String date; // 当前的年月日
    
    public static String LOCAL_IP = null;
    
    private static String LOCAL_IP_Q4 = null;
    
    private static ThreadLocal<String> threadLocaRemark = new ThreadLocal<String>();
    
    static {
        // 获取本机ip
        LOCAL_IP = initLocalAddress();
        // 获取本机ip第四位
        LOCAL_IP_Q4 = formatNumber(Integer.valueOf(LOCAL_IP.split("\\.")[3]), 3);
    }

    public static String getSeqId() {
//        return HedwigContextUtil.getAttribute("reqId", "UNKNOW").toString();
    	return "";
    }

    public static String getRemoteAddress() {
//        return HedwigContextUtil.getAttribute("host.ip", "UNKNOW").toString();
    	return "";
    }
    
    public static String getRemotePoolName() {
//        return HedwigContextUtil.getAttribute(PropKeyConstants.POOL_ID, "UNKNOW").toString();
    	return "";
    }

    private static String initLocalAddress() {
        try
        {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements())
            {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements())
                {
                    ip = (InetAddress) addresses.nextElement();
                    if ((ip != null) && ((ip instanceof Inet4Address))) {
                        return ip.getHostAddress();
                    }
                }
            }
            if (ip == null) {
                ip = InetAddress.getLocalHost();
            }
            return ip.getHostAddress();
        }
        catch (Exception e)
        {
            logger.error("{}", e);
        }
        return "000.000.000.000";
    }
		
		
    public synchronized static String getLogNo() {
		String logNo = threadlocal.get();
		if (StringUtils.isNotBlank(logNo)) {
			return logNo;
		}

		//生成新的logno
		Date now = new Date();
		String str = new SimpleDateFormat("yyMMdd").format(now);
	    if (date == null || str.indexOf(date) != 0) {
	        date = str;
	        index = 0;
	    }
	    if (index >= 999999) {
	        index = 1;
	    } else {
	        index++;
	    }
	    logNo = new SimpleDateFormat("yyMMddhhmmss").format(now) + LOCAL_IP_Q4 + formatNumber(index, 6);
		threadlocal.set(logNo);
        return logNo;
    }
    
    /**
     * 清除当前线程的ThreadLocal, 防止线程池线程复用，导致数据错误
     *
     */
    public static void clearThreadLocal() {
        threadlocal.remove();
        threadLocaRemark.remove();
    }

    /**
     * 格式化数字，前置位不够补0
     *
     * @param num
     *            : 数值
     * @param p
     *            ：位数,最多支持6位
     * @return
     */
    private static String formatNumber(int num, int p) {
        StringBuffer result = new StringBuffer();

        int value = num;
        for (int i = 0; i < p; i++) {
            result.insert(0, value % 10);
            value = value / 10;
        }
        return result.toString();
    }
    
    /**
     * 记录业务日志，最大500个字符
     * @param methedLog
     */
	public static void appendThreadLocaRemark(String methedLog) {
		String log = threadLocaRemark.get();
		if(methedLog!=null){
			if(log!=null && log.length()<512){
				log +=methedLog;
				if(log.length()>512){
					log = log.substring(0,500);
				}
			}else if(log==null){
				log = methedLog;
			}
			
			threadLocaRemark.set(log);
		}
	}
	
	public static String getThreadLocaRemark(){
		return threadLocaRemark.get();
	}
}
