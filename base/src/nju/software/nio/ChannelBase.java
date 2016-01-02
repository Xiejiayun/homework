package nju.software.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Using the channels in nio package
 * Created by Xie on 2016/1/2.
 */
public class ChannelBase {

    public static void main(String[] args) {
        ChannelBase channelBase = new ChannelBase();
        channelBase.writeFileChannel();
//        channelBase.readFileChannel();
        channelBase.transferBetweenChannels();
    }

    public void readFileChannel() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("demo.txt", "rw");
             FileChannel fileChannel = randomAccessFile.getChannel();
        ) {
            printChannelData(fileChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileChannel() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("from.txt", "rw");
             FileChannel fileChannel = randomAccessFile.getChannel();
        ) {
            String str = "hello world!";
            ByteBuffer byteBuffer = ByteBuffer.allocate(66);
            byteBuffer.clear();
            byteBuffer.put(str.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transferBetweenChannels() {
        try (RandomAccessFile fromFile = new RandomAccessFile("from.txt", "rw");
             FileChannel fromChannel = fromFile.getChannel();
             RandomAccessFile toFile = new RandomAccessFile("to.txt", "rw");
             FileChannel toChannel = toFile.getChannel();
        ) {
            long position = 0;
            long count = fromChannel.size();
            fromChannel.transferTo(position, count, toChannel);
            printChannelData(toChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printChannelData(FileChannel toChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(66);
        byteBuffer.clear();
        toChannel.read(byteBuffer);
//        byteBuffer.flip();
        StringBuilder stringBuilder = new StringBuilder("");
        while (byteBuffer.hasRemaining()) {
            char ch = (char) byteBuffer.get();
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder.toString());
    }

}
