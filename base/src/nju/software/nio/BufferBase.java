package nju.software.nio;

import nju.software.util.PrintUtil;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Using the buffer in nio package
 * Created by Xie on 2015/12/19.
 */
public class BufferBase {

    /**
     * using CharBuffer
     */
    public void charbuffer() {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append('o').append('x').append('j').append('y').position(1).limit(9);
        CharBuffer wrapBuffer = CharBuffer.wrap(new char[]{'n', 'e', 't', 'e', 'a', 's', 'e'});
        PrintUtil.print(charBuffer);
        PrintUtil.print(wrapBuffer);
    }

    /**
     * using ShortBuffer
     */
    public void shortbuffer() {

    }

    /**
     * using IntBuffer
     */
    public void intbuffer() {

    }

    /**
     * using LongBuffer
     */
    public void longbuffer() {

    }

    /**
     * using FloatBuffer
     */
    public void floatbuffer() {

    }

    /**
     * using DoubleBuffer
     */
    public void doublebuffer() {

    }

    /**
     * using ByteBuffer
     */
    public void bytebuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');
        byteBuffer.put(0, (byte) 'h').put(new byte[]{',', 'x', 'j', 'y'});
        StringBuilder sb = new StringBuilder("");
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            sb.append((char) byteBuffer.get());//cannot use getChar(), because it will always get two bytes
        }
        String result = sb.toString();
        PrintUtil.print(result);
    }

    public static void main(String[] args) {
        BufferBase base = new BufferBase();
        base.charbuffer();
        base.bytebuffer();
    }

}
