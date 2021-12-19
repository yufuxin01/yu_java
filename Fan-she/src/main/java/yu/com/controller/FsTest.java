package yu.com.controller;

import java.lang.reflect.Constructor;

/**
 * @Classname FsTest
 * @Date 2021/4/10 11:03
 * @Created by yufx
 */
public class FsTest {
    public static void main(String[] args) throws Exception {

        //第一种方式获取Class对象
        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());
        System.out.println(stu1.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("yu.com.controller.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3+"============");
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Class<?> c = String.class;
        try {
            Object str = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //获取String的Class对象
        Class<?> str = Student.class;
//通过Class对象获取指定的Constructor构造器对象
        Constructor constructor=c.getConstructor(String.class);
//根据构造器创建实例：
        Object obj = constructor.newInstance("hello reflection");
        System.out.println(obj);
    }
    public native boolean isInstance(Object obj);
}
