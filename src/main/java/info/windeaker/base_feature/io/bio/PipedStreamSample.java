package info.windeaker.base_feature.io.bio;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author winde
 * @Description 管道流
 * @Date 2020/12/1
 */
public class PipedStreamSample {

    @Test
    public void pipedStreamSample1() {
        final PipedInputStream inputStream = new PipedInputStream();
        final PipedOutputStream outputStream = new PipedOutputStream();
        Thread receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] buf = new byte[2048];
                try {
                    int len = inputStream.read(buf);
                    System.out.println(new String(buf, 0, len));
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                String strInfo = "this is a short message";
                try {
                    outputStream.write(strInfo.getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        receiver.start();
        sender.start();
        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pipedStreamSample2() {
        Receiver receiver = new Receiver();
        Sender sender = new Sender();
        PipedInputStream inputStream=receiver.getPipedInputStream();
        PipedOutputStream outputStream=sender.getPipedOutputStream();

        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        receiver.start();
        sender.start();
    }

    class Receiver extends Thread{
        PipedInputStream   inputStream = new PipedInputStream();

        @Override
        public void run() {
            byte[] buf = new byte[2048];
            try {
                int len = inputStream.read(buf);
                System.out.println(new String(buf, 0, len));
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public PipedInputStream getPipedInputStream(){
            return this.inputStream;
        }
    }
    class Sender extends Thread{
        PipedOutputStream outputStream = new PipedOutputStream();
        @Override
        public void run() {
            String strInfo = "this is a short message";
            try {
                outputStream.write(strInfo.getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public PipedOutputStream getPipedOutputStream(){
            return this.outputStream;
        }
    }

}
