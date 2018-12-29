package com.mengfei.chat;

import java.time.OffsetDateTime;

/**
 * author Alex
 * date 2018/12/29
 * description 一个简单的聊天消息POJO
 */
public class ChatMessage
{
    //当前时区的时间
    private OffsetDateTime timestamp;
    //消息类型
    private Type type;
    //用户名
    private String username;
    //消息内容
    private String content;

    public OffsetDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public static enum Type
    {
        STARTED, JOINED, ERROR, LEFT, TEXT
    }
}
