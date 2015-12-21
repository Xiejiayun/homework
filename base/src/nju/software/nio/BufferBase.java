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
    public void charBuffer() {

        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append('o').append('x').append('j').append('y').position(1).limit(9);
        PrintUtil.print(charBuffer);

        charBuffer.put("1234567", 2, 5);
        charBuffer.flip();
        PrintUtil.print(charBuffer);

        charBuffer.position(9);
        charBuffer.flip();
        PrintUtil.print(charBuffer);

        CharBuffer wrapBuffer = CharBuffer.wrap(new char[]{'n', 'e', 't', 'e', 'a', 's', 'e'});
        PrintUtil.print(wrapBuffer);

        char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        wrapBuffer = CharBuffer.wrap(chars);
        PrintUtil.print(wrapBuffer);



    }

    /**
     * using ShortBuffer
     */
    public void shortBuffer() {

    }

    /**
     * using IntBuffer
     */
    public void intBuffer() {

    }

    /**
     * using LongBuffer
     */
    public void longBuffer() {

    }

    /**
     * using FloatBuffer
     */
    public void floatBuffer() {

    }

    /**
     * using DoubleBuffer
     */
    public void doubleBuffer() {

    }

    /**
     * using ByteBuffer
     */
    public void byteBuffer() {
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
        base.charBuffer();
        base.byteBuffer();

    }

}
