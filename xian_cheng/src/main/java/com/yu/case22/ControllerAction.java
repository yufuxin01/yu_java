package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className ControllerAction
 * @description：
 * @date 2017/12/30 14:19
 */
public class ControllerAction {

    public void execute() {
        String name = "张" + ActionContext.getContext().getId();
        ActionContext.getContext().setName(name);
    }


}
