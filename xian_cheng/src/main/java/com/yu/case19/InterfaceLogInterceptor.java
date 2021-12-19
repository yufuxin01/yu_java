package com.yu.case19;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;


/**
 * Filename: InterfaceLogInterceptor.java
 *
 * @Copyright: Copyright (c)2016
 * @Company: jd
 * @author: huanglaoxie
 * @function: 接口日志拦截器
 * @version: 1.0
 * @Create at: 2016年9月19日 上午10:33:51
 */
public class InterfaceLogInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(InterfaceLogInterceptor.class);

    private static ThreadLocal<String> threadlocal = new ThreadLocal<String>();


    private static String localPoolName = "";
    

    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (!invocation.getMethod().isAnnotationPresent(InterfaceLog.class)) {
            return invocation.proceed();
        }

        if (StringUtils.isNotBlank(threadlocal.get())) {
            return invocation.proceed();
        }
        

        // 注释
        InterfaceLog annotation = invocation.getMethod().getAnnotation(InterfaceLog.class);

        InterfaceLogModel log = new InterfaceLogModel();
        // 获取日志编号
        log.setLogNo(GlobalUtil.getLogNo());
        // client pool
        log.setClientPoolName(GlobalUtil.getRemotePoolName());
        // 客户端IP
        log.setClientIp(GlobalUtil.getRemoteAddress());
        // 记录参数
        log.setSeqId(GlobalUtil.getSeqId());
        // 入参信息
        log.setInputParams(getInputParamsInfo(invocation, annotation));

        threadlocal.set("EXISTS");  // 存在日志标记

        long begin = System.currentTimeMillis();
        Object result = null;
        Exception exp = null;
        Error error = null;
        try {
            result = invocation.proceed();
        }
        catch (Exception e) {
            exp = e;
            logger.error("[ InterfaceLogInterceptor occurs exception ] ", e);
        }
        catch (Error err) {
            logger.error("[ InterfaceLogInterceptor occurs error ] ", err);
            error = err;
        }
        // 记录日志
        log.setCostTime(System.currentTimeMillis() - begin);
        recordLog(log, invocation, result, exp);

        // 清理日志生成器
        GlobalUtil.clearThreadLocal();
        threadlocal.remove();

        // 抛出异常
        if (exp != null) {
            throw exp;
        }
        if (error != null) {
            throw error;
        }
        return result;
    }

    /**
     *
     * 记录日志
     *
     * @param invocation
     * @param input
     * @param result
     */
    private void recordLog(InterfaceLogModel log, MethodInvocation invocation, Object result, Exception exp) {
        try {
            InterfaceLog annotation = invocation.getMethod().getAnnotation(InterfaceLog.class);
            // server pool
            log.setServerPoolName(localPoolName);
            // 服务名
            log.setServiceName(invocation.getMethod().getDeclaringClass().getName());
            // 方法名
            log.setMethodName(invocation.getMethod().getName());
            // 服务端IP
            log.setServerIp(GlobalUtil.LOCAL_IP);
            // 创建时间
            log.setCreateTime(new Date());
            // 更新时间
            log.setUpdateTime(new Date());
            // 出参信息
            log.setOutputParams(getOutputParamsInfo(invocation, result));
            // 关键字
            log.setKeyword(getKeyWorrdInfo(annotation, invocation.getArguments()));
            // 异常信息
            log.setExcptionPrintInfo(getExceptionInfo(exp));
            // 方法主动记录注释
            log.setRemark(GlobalUtil.getThreadLocaRemark());

            // 处理日志
            InterfaceLogHandler.getInterfaceLogHandlerInstance().handleLogReq(log);

        }
        catch (Exception e) {
            logger.error("[ record log occurs exception ] ", e);
        }
    }

    private String getInputParamsInfo(MethodInvocation invocation, InterfaceLog annotation) {
        if (annotation.paramRecorderType() == InputParamType.NONE) {
            return "NA";
        }
        Object[] args = invocation.getArguments();
        if ((args == null) || (args.length <= 0)) {
            return null;
        }

        Gson gson = new Gson();
        String resultStr = gson.toJson(args);
        if (resultStr.length() > 2000) {
            resultStr = resultStr.substring(0, 2000);
        }
        return resultStr;
    }

    private String getOutputParamsInfo(MethodInvocation invocation, Object result) {
        if (result != null) {
            Gson gson = new Gson();
            String resultStr = gson.toJson(result);
            if (resultStr.length() > 2000) {
                resultStr = resultStr.substring(0, 2000);
            }
            return resultStr;
        }
        return null;
    }

    private String getExceptionInfo(Exception exp) {
        if (exp == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            exp.printStackTrace(pw);
            String exceptionStr = sw.toString();
            if (exceptionStr.length() > 2000) {
                exceptionStr = exceptionStr.substring(0, 2000);
            }
            return exceptionStr;
        }
        catch (Exception e) {
            logger.error("get exception info error", e);
        }
        finally {
            try {
                sw.close();
            }
            catch (IOException e) {
                logger.error("{}", e);
            }
            pw.close();
        }
        return null;
    }

    private String getKeyWorrdInfo(InterfaceLog annotation, Object[] args) {
        if ((args == null) || (args.length <= 0)) {
            return null;
        }
        int index = annotation.keywordIndex();
        if (index >= args.length) {
            return null;
        }
        Object o = args[index];
        if (o == null) {
            return null;
        }
        if(o instanceof Collection){
            Object[] array = ((Collection) o).toArray();
            if(array.length > 0){
                o = array[0];
            }
            if(o == null){
                return null;
            }
        }
        if ((o instanceof String)) {
            return o.toString();
        }
        if (((o instanceof Integer)) || ((o instanceof Long))
                || ((o instanceof Double))) {
            return String.valueOf(o);
        }
        if ((o instanceof Map)) {
            String key = annotation.keywordField();
            if ((key == null) || ("".equals(key.trim()))) {
                return null;
            }
            Object value = ((Map) o).get(key);
            return value.toString();
        }
        String field = annotation.keywordField();
        if ((field == null) || (field.trim().length() <= 0)) {
            return null;
        }
        try {
            Method method = o.getClass().getMethod(getFieldMethodName(field), (Class[]) null);
            Object refValue = method.invoke(o, (Object[]) null);
            if (refValue == null) {
                return null;
            }
            return refValue.toString();
        }
        catch (Exception e) {
            logger.error("get keyword error", e);
        }
        return null;
    }

    private String getFieldMethodName(String refCodeFiled) {
        String s = refCodeFiled.trim();
        return "get" + s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }
}
