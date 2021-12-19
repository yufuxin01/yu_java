package StringUtilsAA;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
/**
 * @Classname Test1
 * @Date 2021/4/9 15:47
 * @Created by yufx
 */
public class Test1 {
    // 官方文档: http://commons.apache.org/proper/commons-lang/javadocs/api-3.6/
    @Test
    public void test() {

        // --------empty/blank
        // ############################检查字符串是否包含文本###############################
        String str = "";
        boolean empty = StringUtils.isEmpty(str);// 判断字符串是否为空,返回true,空格返回false
        System.out.println("empty--->" + empty);
        boolean notEmpty = StringUtils.isNotEmpty(str);// 判断字符串是否为空,返回false,空格返回true
        System.out.println("notEmpty--->" + notEmpty);
        boolean blank = StringUtils.isBlank(str);// 判断字符串是否为空,包括空格,返回true
        System.out.println("blank--->" + blank);
        boolean notBlank = StringUtils.isNotBlank(str);// 判断字符串是否为空,包括空格,返回false
        System.out.println("notBlank--->" + notBlank);

        // --------trim/strip
        // ############################删除前导和尾随空格###################################
        String trim = StringUtils.trim(str);
        System.out.println("trim--->" + trim);// 去掉字符串开始,结尾的所有空格
        String strip = StringUtils.strip(str);
        System.out.println("strip--->" + strip);// 去掉字符串开始,结尾的所有空格
        String trimToNull = StringUtils.trimToNull(str);// 去掉字符串开始,结尾的所有空格,当字符串为"",null或者" "时返回null
        System.out.println("trimToNull--->" + trimToNull);
        String trimToEmpty = StringUtils.trimToEmpty(str);// 去掉字符串开始,结尾的所有空格,当字符串为null时返回""
        System.out.println("trimToEmpty--->" + trimToEmpty);

        // --------equals
        // ############################比较两个空安全的字符串#################################
        boolean equals = StringUtils.equals(null, null);// 判断连个字符串是否相等
        System.out.println("equals--->" + equals);

        // --------startWith/endsWith
        // ############################判断字符串的前缀/后缀-->是否为另一个字符串#################
        boolean startWith = StringUtils.startsWith("ull1233", "ull");
        System.out.println("startWith--->" + startWith);
        boolean endsWith = StringUtils.endsWith("abcefd", "");// 为""时 返回true
        System.out.println("endsWith--->" + endsWith);
        boolean startsWithIgnoreCase = StringUtils.startsWithIgnoreCase("aad123lcg", "aA");// 忽略大小写
        System.out.println("startsWithIgnoreCase--->" + startsWithIgnoreCase);

        // --------ContainsOnly/ContainsNone/ContainsAny
        // ###########################检查字符序列是否只包含某些字符#############################
        boolean contains = StringUtils.contains("fasdfasfcv", "fasf");// 判断字符串是否包含某个字符串
        System.out.println("contains--->" + contains);
        boolean containsAny = StringUtils.containsAny("hi,hello,", "o,", "hi");// 判断字符串是否包含多个字符串
        System.out.println("containsAny--->" + containsAny);

        // --------UpperCase/LowerCase
        // ###########################字符串大小写转化########################################
        String lowerCase = StringUtils.lowerCase("jubnskdFSDAFDShgfdgds");//-->jubnskdfsdafdshgfdgds
        System.out.println("lowerCase"+lowerCase);
        String upperCase = StringUtils.upperCase("dasfdsfFASDGFsda");//-->DASFDSFFASDGFSDA
        System.out.println("upperCase--->"+upperCase);

        //更多请查看官方文档,文档非常详细






    }
}
