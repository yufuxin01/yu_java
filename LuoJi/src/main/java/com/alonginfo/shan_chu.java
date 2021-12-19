package com.alonginfo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/29 19:53
 */
public class shan_chu {
    public static void main(String[] args) {
        User user1 = new User(1, "冷言1", "001");
        User user3 = new User(3, "冷言3", "002");
        User user2 = new User(2, "冷言2", "001");
        ArrayList<User> ulist = new ArrayList<>();
        ulist.add(user1);
        ulist.add(user2);
        ulist.add(user3);
        for (int i = 0; i < ulist.size(); i++) {
            System.out.println(ulist.get(i));
            if("001" .equals(ulist.get(i).getAa())){
                ulist.remove(i);
            }
        }

        for (User user : ulist) {
            if("001".equals(user.getAa())){
                ulist.remove(user);
            }
        }

        Iterator<User> iterator = ulist.iterator();
        while (iterator.hasNext()){
            if("001".equals(iterator.next().getAa())){
                iterator.remove();
            }
        }
        System.out.println(ulist);
    }
}
