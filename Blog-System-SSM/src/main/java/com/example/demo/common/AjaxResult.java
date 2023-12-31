package com.example.demo.common;

import lombok.Data;

import java.io.Serializable;

/*
*统一数据返回
 */
@Data
public class AjaxResult implements Serializable {
    //状态码
    private Integer code;
    //状态码描述信息
    private String msg;
    //返回的数据
    private Object data;

    /*
    *操作成功返回的结果
     */
    public static AjaxResult success(Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(200);
        ajaxResult.setData(data);
        ajaxResult.setMsg("");
        return ajaxResult;
    }

    public static AjaxResult success(int code,Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setData("");
        ajaxResult.setData(data);
        return ajaxResult;
    }
    public static AjaxResult success(int code,String msg,Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setData(data);
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }
    /*
    *返回失败结果
     */
    public static AjaxResult fail(int code,String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setData(msg);
        return ajaxResult;
    }

}
