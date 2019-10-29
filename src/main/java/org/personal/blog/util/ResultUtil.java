package org.personal.blog.util;

import org.personal.blog.pojo.result.Result;
import org.personal.blog.consts.ResultBaseCode;
import org.personal.blog.consts.ResultBaseMsg;

/**
 * Created by zs on 2019/8/1
 * 返回结果工具类
 */
public class ResultUtil {

    /**
     * @Param []
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:35
     * 功能描述：默认成功(带参数)
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultBaseCode.SUCCESS_CODE);
        result.setMsg(ResultBaseMsg.SUCCESS_MSG);
        result.setData(object);
        return result;
    }
    /**
     * @Param [object]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:43
     * 功能描述：默认失败(带参数)
     */
    public static Result error(Object object){
        Result result = new Result();
        result.setCode(ResultBaseCode.ERROR_CODE);
        result.setMsg(ResultBaseMsg.ERROR_MSG);
        result.setData(object);
        return result;
    }
    /**
     * @Param [object]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:53
     * 功能描述：异常
     */
    public static Result exception(Object object){
        Result result = new Result();
        result.setCode(ResultBaseCode.EXCETION_CODE);
        result.setMsg(ResultBaseMsg.EXCEPTION_MSG);
        result.setData(object);
        return result;
    }
    /**
     * @Param [code, msg, object]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:55
     * 功能描述：异常
     */
    public static Result exception(Integer code, String msg, Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    /**
     * @Param [code, msg]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:55
     * 功能描述：异常
     */
    public static Result exception(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    /**
     * @Param []
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:55
     * 功能描述：异常
     */
    public static Result exception(){
        Result result = new Result();
        result.setCode(ResultBaseCode.EXCETION_CODE);
        result.setMsg(ResultBaseMsg.EXCEPTION_MSG);
        return result;
    }
    /**
     * @Param []
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:44
     * 功能描述：默认成功无参
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(ResultBaseCode.SUCCESS_CODE);
        result.setMsg(ResultBaseMsg.SUCCESS_MSG);
        return result;
    }
    /**
     * @Param []
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:45
     * 功能描述：默认失败无参
     */
    public static Result error(){
        Result result = new Result();
        result.setCode(ResultBaseCode.ERROR_CODE);
        result.setMsg(ResultBaseMsg.ERROR_MSG);
        return result;
    }
    /**
     * @Param [code, msg, object]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:46
     * 功能描述：成功有参
     */
    public static Result success(Integer code, String msg, Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    /**
     * @Param [code, msg, object]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:47
     * 功能描述：成功有参
     */
    public static Result error(Integer code, String msg, Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    /**
     * @Param [code, msg]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:47
     * 功能描述：成功有参
     */
    public static Result success(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    /**
     * @Param [code, msg]
     * @Return org.personal.blog.pojo.result.Result
     * @Author zs
     * @Date 2019/8/1 15:47
     * 功能描述：失败有参
     */
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
