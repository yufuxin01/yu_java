package StringUtilsAA;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @Classname Test2
 * @Date 2021/4/10 9:41
 * @Created by yufx
 */
public class Test2 {
    @Test
    public void test() {
        String str = "q";
        Student s = new Student("123","");
        boolean noneBlank = StringUtils.isNoneBlank(str);
        System.out.println(noneBlank);

    }
    @Test
    public void Demo() {

    }
}
