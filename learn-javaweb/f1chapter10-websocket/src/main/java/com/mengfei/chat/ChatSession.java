package com.mengfei.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.websocket.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author Alex
 * date 2018/12/29
 * description 一个用于关联客户和客服人员的会话类
 */
public class ChatSession
{
    //会话ID
    private long sessionId;
    //客户用户名
    private String customerUsername;
    //客户session
    private Session customer;
    //客服用户名
    private String customerServiceUsername;
    //客服session
    private Session customerService;
    //创建的消息对象
    private ChatMessage creationMessage;
    //聊天日志
    private final List<ChatMessage> chatLog = new ArrayList<>();

    public long getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(long sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getCustomerUsername()
    {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername)
    {
        this.customerUsername = customerUsername;
    }

    public Session getCustomer()
    {
        return customer;
    }

    public void setCustomer(Session customer)
    {
        this.customer = customer;
    }

    public String getCustomerServiceUsername() {
        return customerServiceUsername;
    }

    public void setCustomerServiceUsername(String customerServiceUsername) {
        this.customerServiceUsername = customerServiceUsername;
    }

    public Session getCustomerService() {
        return customerService;
    }

    public void setCustomerService(Session customerService) {
        this.customerService = customerService;
    }

    public ChatMessage getCreationMessage()
    {
        return creationMessage;
    }

    public void setCreationMessage(ChatMessage creationMessage)
    {
        this.creationMessage = creationMessage;
    }

    @JsonIgnore
    public void log(ChatMessage message)
    {
        this.chatLog.add(message);
    }

    @JsonIgnore
    public void writeChatLog(File file) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try(FileOutputStream stream = new FileOutputStream(file))
        {
            mapper.writeValue(stream, this.chatLog);
        }
    }
}

