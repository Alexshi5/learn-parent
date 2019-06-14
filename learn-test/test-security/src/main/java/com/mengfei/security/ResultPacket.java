package com.mengfei.security;

import java.io.Serializable;
import java.util.Objects;

public class ResultPacket implements Serializable {
    private boolean isError;
    private String errorCode;
    private String description;
    private Object dataObject;

    public ResultPacket() {
        this.isError = false;
        this.errorCode = "00";
        this.description = "操作成功";
        this.dataObject = null;
    }
    public ResultPacket(String errorCode,String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
    public ResultPacket(boolean isError, String errorCode, String description) {
        this.isError = isError;
        this.errorCode = errorCode;
        this.description = description;
        this.dataObject = null;
    }
    public ResultPacket(boolean isError, String errorCode, String description,Object dataObject) {
        this.isError = isError;
        this.errorCode = errorCode;
        this.description = description;
        this.dataObject = dataObject;
    }

    public boolean getIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        isError = isError;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getDataObject() {
        return dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public String toString() {
        return "ResultPacket{" +
                "isError=" + isError +
                ", errorCode='" + errorCode + '\'' +
                ", description='" + description + '\'' +
                ", dataObject=" + dataObject +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultPacket that = (ResultPacket) o;
        return isError == that.isError &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dataObject, that.dataObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isError, errorCode, description, dataObject);
    }
}
