package info.windeaker.base_feature.encrypt;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author windeaker
 *
 */
public class Base64Util {

    // default charset
    public static Charset defCharset=StandardCharsets.UTF_8;

    public static String doEncode(String origin,Charset charset){
        String result=null;
        Base64.Encoder encoder=Base64.getEncoder();
        if (charset!=null) {
            result = encoder.encodeToString(origin.getBytes(charset));
        }else{
            result = encoder.encodeToString(origin.getBytes());
        }
        return result;
    }

    public static String doDecode(String decode,Charset outStrCharset){
        String result=null;
        Base64.Decoder decoder=Base64.getDecoder();
        if (outStrCharset!=null) {
            result = new String(decoder.decode(decode),outStrCharset);
        }else{
            result = new String(decoder.decode(decode),StandardCharsets.UTF_8);
        }
        return result;
    }

    public static String generateImage2String(){
        return null;
    }
}
