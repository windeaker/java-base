package info.windeaker.base_feature.io.bio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/23
 */
public class FileHeadDemo {

    @Test
    public void writeToFileInBinary() {
        File file = new File(System.getProperty("user.dir") + "/files/a.txt");
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("东风夜放花千树，更吹落，星如雨".getBytes(StandardCharsets.UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void readFileHead() {
        File file = new File(System.getProperty("user.dir") + "/files/头像.jpg");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] cache=new byte[128];
            fileInputStream.read(cache);
            for (int i = 0; i < cache.length; i++) {
                System.out.print(cache[i]);
            }
            System.out.println();
            System.out.println(bytesToHexString(cache));
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将文件头转换成16进制字符串
     */
    private static String bytesToHexString(byte[] src){

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
