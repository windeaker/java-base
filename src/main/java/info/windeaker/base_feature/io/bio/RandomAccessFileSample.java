package info.windeaker.base_feature.io.bio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/1
 */
public class RandomAccessFileSample {

    @Test
    public void readData() throws IOException {

        RandomAccessFile randomAccessFile=new RandomAccessFile("D:\\GitHub\\java-base\\README.md", "r");
        System.out.println("当前记录指针位置：" + randomAccessFile.getFilePointer());
        byte[] buf = new byte[1024];
        int	len = 0;
        while((len = randomAccessFile.read(buf)) != -1) {
            System.out.println(new String(buf));
        }
        System.out.println("当前记录指针位置：" + randomAccessFile.getFilePointer());
    }

    @Test
    public void writeData(){

    }
}
