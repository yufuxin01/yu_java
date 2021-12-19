package com.yu.case19;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Test {

    public static void main(String[] args) {
        InterfaceLogModel interfaceLog;
        for (int i = 0; i < Constant.totalRecords; i++) {
            interfaceLog = new InterfaceLogModel();
            interfaceLog.setClientIp("127.0.0.2");
            interfaceLog.setClientPoolName("jd shangcheng");
            interfaceLog.setCostTime(10L);
            interfaceLog.setCreateTime(new Date());
            interfaceLog.setInputParams("input param"+i);
            interfaceLog.setKeyword("keyword1");
            interfaceLog.setLogNo(DistrIdGenerator2.createDistrId());
            interfaceLog.setMethodName("test");
            interfaceLog.setOutputParams("1");
            interfaceLog.setServerIp("127.0.0.1");
            interfaceLog.setServerPoolName("markting");
            interfaceLog.setServiceName("genRedEnvelopes");
            interfaceLog.setUpdateTime(new Date());
            interfaceLog.setId(1L);
            InterfaceLogHandler.getInterfaceLogHandlerInstance().handleLogReq(interfaceLog);
        }

    }

}
