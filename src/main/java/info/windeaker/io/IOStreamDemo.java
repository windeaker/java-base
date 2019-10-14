package info.windeaker.io;

import com.sun.istack.internal.NotNull;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class IOStreamDemo {
    public static void main(String[] args) throws IOException {
        read(new File(System.getProperty("user.dir")+File.separator+"io"));
    }

    static void read(@NotNull File file) throws IOException {
        InputStream in=new FileInputStream(file);
        byte[] buffer=new byte[32];
        System.out.println(buffer[0]);
        int length=-1;
        StringBuilder builder=new StringBuilder();
        while((length=in.read(buffer))!=-1){
            if (length!=buffer.length) {
                builder.append(new String(buffer,0,length,Charset.forName("GBK")));
            }else{
                builder.append(new String(buffer, Charset.forName("GBK")));
            }
            for(int i=0;i<length;i++){
                System.out.println(buffer[i]);
            }
        }
        System.out.println(builder.toString());
        in.close();
    }

}