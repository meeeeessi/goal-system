package org.wang.goal.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Timestamp getCurrentDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String format = simpleDateFormat.format(date.getTime());
        Timestamp ts = Timestamp.valueOf(format);
        System.out.println(ts+"-----------------------");
        return ts;
    }

    //将字符串转换为Timestamp
    public static Timestamp typeSwitch(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=simpleDateFormat.parse(time);
        return new Timestamp(date.getTime());
    }

}
