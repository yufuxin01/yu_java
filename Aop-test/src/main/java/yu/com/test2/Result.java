package yu.com.test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装返回结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Result implements Serializable{
    private boolean success;//执行结果，true为执行成功 false为执行失败
    private String msg;//返回结果信息，主要用于页面提示信息
    private Object data;//返回数据

    public static Result okData(Object data) {
        Result result = new Result();
        result.data = data;
        return result;
    }

    public static Result okDataMsg(Object data , String msg) {
        Result result = new Result();
        result.data = data;
        result.msg = msg;
        return result;
    }

    public static Result okDataMsgSuccess(Object data, String msg ,boolean success) {
        Result result = new Result();
        result.data = data;
        result.msg = msg;
        result.success = success;
        return result;
    }

}
