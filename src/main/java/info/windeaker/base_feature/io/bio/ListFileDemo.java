package info.windeaker.base_feature.io.bio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFileDemo {
    public static void main(String[] args) {
        File originMusicDir=new File("E:\\Music\\ALL");
        File[] tmpfiles=originMusicDir.listFiles();
        List originMusicFileList=new ArrayList<File>();
        for(File temp:tmpfiles){
            if (temp.getName().endsWith(".mp3")){
                originMusicFileList.add(temp);
            }
        }
        System.out.println(originMusicFileList);
//        File hyperMusicDir=new File("E:\\Music\\")
    }
}
