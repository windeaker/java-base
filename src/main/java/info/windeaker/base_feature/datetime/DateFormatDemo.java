package info.windeaker.base_feature.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
    }
}
