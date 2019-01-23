package com.mengfei.chat;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * author Alex
 * date 2018/12/29
 * description 一个编解码器类
 */
public class ChatMessageCodec
        implements Encoder.BinaryStream<ChatMessage>,
        Decoder.BinaryStream<ChatMessage>
{
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.findAndRegisterModules();
        MAPPER.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
    }

    @Override
    public void encode(ChatMessage chatMessage, OutputStream outputStream)
            throws EncodeException, IOException
    {
        try
        {
            ChatMessageCodec.MAPPER.writeValue(outputStream, chatMessage);
        }
        catch(JsonGenerationException | JsonMappingException e)
        {
            throw new EncodeException(chatMessage, e.getMessage(), e);
        }
    }

    @Override
    public ChatMessage decode(InputStream inputStream)
            throws DecodeException, IOException
    {
        try
        {
            return ChatMessageCodec.MAPPER.readValue(
                    inputStream, ChatMessage.class
            );
        }
        catch(JsonParseException | JsonMappingException e)
        {
            throw new DecodeException((ByteBuffer)null, e.getMessage(), e);
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) { }

    @Override
    public void destroy() { }
}