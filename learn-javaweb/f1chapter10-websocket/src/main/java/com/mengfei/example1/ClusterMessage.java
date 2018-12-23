package com.mengfei.example1;

import java.io.Serializable;

/**
 * author Alex
 * date 2018/12/23
 * description 一个实现序列化接口的集群消息POJO类
 */

public class ClusterMessage implements Serializable
{
    private static final long serialVersionUID = -5309990726684354266L;
    private String nodeId;

    private String message;

    public ClusterMessage()
    {

    }

    public ClusterMessage(String nodeId, String message)
    {
        this.nodeId = nodeId;
        this.message = message;
    }

    public String getNodeId()
    {
        return nodeId;
    }

    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}