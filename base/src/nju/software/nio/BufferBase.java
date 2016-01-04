package nju.software.nio;

import nju.software.util.PrintUtil;

import java.nio.*;

/**
 * Using the buffer in nio package
 * Created by Xie on 2015/12/19.
 */
public class BufferBase {

    public static void main(String[] args) {
        BufferBase base = new BufferBase();
        base.charBuffer();
        base.shortBuffer();
        base.intBuffer();
        base.longBuffer();
        base.floatBuffer();
        base.doubleBuffer();
        base.byteBuffer();
    }

    /**
     * using CharBuffer
     */
    public void charBuffer() {

        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append('o').append('x').append('j').append('y').position(1).limit(9);
        PrintUtil.print("charBuffer " + charBuffer);

        charBuffer.put("1234567 ", 2, 5);
        charBuffer.flip();
        PrintUtil.print("charBuffer " + charBuffer);

        charBuffer.position(3);
        charBuffer.flip();
        PrintUtil.print("charBuffer " + charBuffer);

        //using duplicate method, it shows that once duplicate is finished
        CharBuffer dupBuffer = charBuffer.duplicate();
        dupBuffer.position(2);
        charBuffer.position(1);
        PrintUtil.print("dupBuffer " + dupBuffer);
        PrintUtil.print("charBuffer " + charBuffer);
        System.out.println("dupBuffer posistion" + dupBuffer.position() + " dupBuffer limit " + dupBuffer.limit());
        System.out.println("charBuffer posistion" + charBuffer.position() + " charBuffer limit " + charBuffer.limit());
        dupBuffer.clear();
        charBuffer.clear();
        //they always share the same buffer, but with different position and limit
        dupBuffer.put('e').put('a').put('s').put('e').flip();
        charBuffer.put('n').put('e').put('t').flip();
        PrintUtil.print("dupBuffer " + dupBuffer);
        PrintUtil.print("charBuffer " + charBuffer);


        //using wrap method, it uses char array as input
        CharBuffer wrapBuffer = CharBuffer.wrap(new char[]{'n', 'e', 't', 'e', 'a', 's', 'e'});
        PrintUtil.print("wrapBuffer " + wrapBuffer);

        char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        wrapBuffer = CharBuffer.wrap(chars);
        PrintUtil.print("wrapBuffer " + wrapBuffer);

    }

    /**
     * using ShortBuffer
     */
    public void shortBuffer() {
        ShortBuffer shortBuffer = ShortBuffer.allocate(10);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 1);
        System.out.println("shortBuffer " + shortBuffer);
    }

    /**
     * using IntBuffer
     */
    public void intBuffer() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(1);
        intBuffer.put(2, 2);
        System.out.println("intBuffer" + intBuffer);

    }

    /**
     * using LongBuffer
     */
    public void longBuffer() {
        LongBuffer longBuffer = LongBuffer.allocate(10);
        longBuffer.put(1);
        longBuffer.put(1);
        longBuffer.put(1);
        longBuffer.put(1);
        longBuffer.put(1);
        longBuffer.put(1);
        longBuffer.put(1);
        System.out.println("longBuffer " + longBuffer);
        System.out.println("longBuffer " + longBuffer.slice().get(2));
    }

    /**
     * using FloatBuffer
     */
    public void floatBuffer() {
        FloatBuffer buffer = FloatBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); ++i) {
            float f = (float) (i);
            buffer.put(f);
        }
        System.out.println(buffer.toString());
        buffer.flip();
        while (buffer.hasRemaining()) {
            float f = buffer.get();
            System.out.println(f);
        }
    }

    /**
     * using DoubleBuffer
     */
    public void doubleBuffer() {
        DoubleBuffer doubleBuffer = DoubleBuffer.allocate(10);
        System.out.println("doubleBuffer " + doubleBuffer);
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
            sb.append((char) byteBuffer.get());//cannot use getChar(), because it will always get two bytes once
        }
        String result = sb.toString();
        PrintUtil.print(result);

    }

}
