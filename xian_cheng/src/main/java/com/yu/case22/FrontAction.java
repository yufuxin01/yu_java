package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className FrontAction
 * @description：
 * @date 2017/12/30 14:21
 */
public class FrontAction {

    public void execute(){
        User context = ActionContext.getContext();
        String id = getUserId();
        context.setId(id);
    }

    public String getUserId(){
        return String.valueOf(Thread.currentThread().getId());
    }


}
