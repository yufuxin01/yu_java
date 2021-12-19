package com.yu.case21;

import java.util.concurrent.TimeUnit;


public class People implements Runnable {
    private IntelligentMeeting conference;
    private String name;

    public People(IntelligentMeeting conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
    }

}
