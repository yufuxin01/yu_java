package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className ActionContext
 * @description：
 * @date 2017/12/30 14:18
 */
public class ActionContext {
    private  static final ThreadLocal<User> threadLocal = new ThreadLocal<User>(){
        @Override
        protected User initialValue() {
            return new User();
        }
    };

//  private static final ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    public static User getContext(){
        return threadLocal.get();
    }

    public static void removeValue(Object key) {
       User user= threadLocal.get();
       if(null!=user){
           threadLocal.remove();
       }

    }

}
