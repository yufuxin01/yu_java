package com.alonginfo.modle;

import lombok.*;

import java.util.List;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/11/30 16:07
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fanyi {
    /*
APP ID：20201124000624414
密钥：xqCZvzpmT3GoupnHQJdm
     */
    private String q; //请求翻译 query UTF-8 编码
    private String from; // 翻译源语言  可设置为 auto
    private String to; //翻译目标语言	   不可设置为 auto
    private String appid = "20201124000624414"; // APP ID
    private String miyao = "xqCZvzpmT3GoupnHQJdm"; // 密钥
    private String salt = "1435660288"; // 随机数
    private String sign; // 签名	appid+q+salt+密钥 的MD5值



    private List<String> trans_result; // 翻译结果 src==>原文 dst==>译文
    private Integer error_code; // 错误码  仅当出现时错误时显示

}
