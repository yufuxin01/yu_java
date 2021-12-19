package com.yu.case19;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Filename: InterfaceLog.java
 * 
 * @Copyright: Copyright (c)2016
 * @Company: jd
 * @author: huanglaoxie
 * @function:
 * @version: 1.0
 * @Create at: 2016年9月19日 上午10:49:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.METHOD })
public @interface InterfaceLog {
    
	InputParamType paramRecorderType() default InputParamType.ALL;
	
	int[] paramRecorderIndex() default {};

	int keywordIndex() default 0;

	String keywordField() default "";

}
