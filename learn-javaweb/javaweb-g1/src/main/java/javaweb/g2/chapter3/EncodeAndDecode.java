package javaweb.g2.chapter3;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * 编码与解码
 */
public class EncodeAndDecode {
    public static void main(String[] args) throws Exception {
        String s = "这是一段字符串";
        byte[] bytes = s.getBytes("utf-8");
        String s1 = new String(bytes, "utf-8");
    }

    public void test() {
        String s = "这是一段字符串";
        Charset charset = Charset.forName("utf-8");
        //char[]到byte[]
        ByteBuffer byteBuffer = charset.encode(s);
        //byte[]到char[]
        CharBuffer charBuffer = charset.decode(byteBuffer);
    }

    public void test1() {
        char c = 'a';
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer = buffer.putChar(c);
    }
}
