package com.yu.case21;


public class Test {
    public static void main(String[] args) {
        // 创建一个智能会议系统对象，它有20个参与者
        IntelligentMeeting meeting = new IntelligentMeeting(20);
        Thread threadConference = new Thread(meeting);
        threadConference.start();

        // 创建20个参会人员，每个参会人员都是并行运行
        for (int i = 1; i < 21; i++) {
            People p = new People(meeting, "参会人员" + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
