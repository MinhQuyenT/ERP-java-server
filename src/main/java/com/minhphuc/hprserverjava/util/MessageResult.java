package com.minhphuc.hprserverjava.util;

import lombok.Data;

@Data
public class MessageResult {

    private int code;

    private Object data;

    private String msg;

    public static MessageResult result(int code,String msg, Object data){
        MessageResult result = new MessageResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    };

    public static MessageResult success(String msg, Object data){
        MessageResult result = new MessageResult();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(data);
        return result;
    };

    public static MessageResult success( Object data){
        MessageResult result = new MessageResult();
        result.setCode(0);
        result.setMsg("Operation successful.");
        result.setData(data);
        return result;
    };

    public static MessageResult success(Integer codeMsg,Object data){
        MessageResult result = new MessageResult();
        result.setCode(0);
        result.setMsg("Operation successful.");
        result.setData(data);
        return result;
    };

    public static MessageResult error(Integer codeMsg){
        MessageResult result = new MessageResult();
        result.setCode(-1);
        result.setMsg("Operation successful.");
        result.setData(null);
        return result;
    };

    public static MessageResult error(String msg){
        MessageResult result = new MessageResult();
        result.setCode(-1);
        result.setMsg(msg);
        result.setData(null);
        return result;
    };

    public static MessageResult errorNotPerm(){
        MessageResult result = new MessageResult();
        result.setCode(-1);
        result.setMsg("You have not been granted permission to access this API operation");
        result.setData(null);
        return result;
    };

}
