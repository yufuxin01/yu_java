package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Request
 * @description：
 * @date 2017/12/30 14:23
 */
public class Request implements Runnable{

    private ControllerAction queryController = new ControllerAction();
    private FrontAction queryFront = new FrontAction();

    @Override
    public void run() {
        User user = ActionContext.getContext();
        queryFront.execute();
        queryController.execute();
        System.out.println("user id is : "+user.getId()+" ,and user  name is " + user.getName() );
        ActionContext.removeValue(user);
//        System.out.println("user11 id is : "+ActionContext.getContext().getId()+" ,and user11  name is " + ActionContext.getContext().getName() );
    }

}
