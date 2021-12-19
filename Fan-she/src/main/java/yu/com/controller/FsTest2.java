package yu.com.controller;

/**
 * @Classname FsTest2
 * @Date 2021/4/10 11:12
 * @Created by yufx
 */
public class FsTest2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> c = String.class;
        Object str = c.newInstance();
    }
}
