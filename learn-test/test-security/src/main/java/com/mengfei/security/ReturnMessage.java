package com.mengfei.security;

import java.io.Serializable;
import java.util.List;
/*
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
*/

/*@JsonSerialize(
    include = Inclusion.NON_NULL
)*/
public class ReturnMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code = "";
    private String mesg = "";
    private List<T> list;
    private List objList;
    private SplitPage splitPage;
    private T object;
    private String splitPageString;
    private int successCount = 0;
    private boolean isError;
    private Object OthersObject;

    public ReturnMessage() {
        this.isError = false;
        this.code = "000";
        this.mesg = "ok";
        this.object = null;
    }

    public ReturnMessage(boolean isError,String code, String mesg) {
        this.isError = isError;
        this.code = code;
        this.mesg = mesg;
    }

    public ReturnMessage(boolean isError,String code, String mesg,T object) {
        this.isError = isError;
        this.code = code;
        this.mesg = mesg;
        this.object = object;
    }

    public ReturnMessage(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

    public ReturnMessage(String code, String mesg, T object) {
        this.isError = false;
        this.code = code;
        this.mesg = mesg;
        this.object = object;
    }

    public ReturnMessage(String code, String mesg, List<T> list) {
        this.isError = false;
        this.code = code;
        this.mesg = mesg;
        this.list = list;
    }

    public ReturnMessage(String code, String mesg, List<T> list, SplitPage splitPage) {
        this.isError = false;
        this.code = code;
        this.mesg = mesg;
        this.list = list;
        this.splitPage = splitPage;
    }

    public boolean getIsError() {
        return isError;
    }

    public void setIsError(boolean error) {
        isError = error;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return this.mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public String getSplitPageString() {
        return this.splitPageString;
    }

    public void setSplitPageString(String splitPageString) {
        this.splitPageString = splitPageString;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObject() {
        return this.object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public SplitPage getSplitPage() {
        return this.splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public List getObjList() {
        return this.objList;
    }

    public void setObjList(List objList) {
        this.objList = objList;
    }

    public Object getOthersObject() {
        return OthersObject;
    }

    public void setOthersObject(Object othersObject) {
        OthersObject = othersObject;
    }

    /* public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", this.code);
        jsonObject.put("mesg", this.mesg);
        jsonObject.put("obj", this.object);
        jsonObject.put("list", this.list);
        return jsonObject.toString();
    }*/
}
