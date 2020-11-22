package info.windeaker.base_feature.encrypt;

import org.junit.Assert;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util{

    private final static String[] hexDigIts={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String md5Encode(String origin, Charset charset){
        Assert.assertNotNull(origin);
        String result=null;
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            if (charset!=null){
                result = byteArrayToHexString(md.digest(result.getBytes(charset)));
            }else{
                result = byteArrayToHexString(md.digest(result.getBytes()));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("wrong algorithm");
        }
        return result;
    }

    private static String byteArrayToHexString(byte b[]){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<b.length;i++){
            stringBuilder.append(byteToHexString(b[i]));
        }
        return stringBuilder.toString();
    }

    private static String byteToHexString(byte b){
        int n=b;
        if(n<0){
            n+=256;
        }
        int d1=n/16;
        int d2=n%16;
        return hexDigIts[d1]+hexDigIts[d2];
    }
}
