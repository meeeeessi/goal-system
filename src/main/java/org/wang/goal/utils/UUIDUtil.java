package org.wang.goal.utils;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        String id = UUID.randomUUID().toString();
        String uuid = id.substring(0, 8) + id.substring(9, 13) + id.substring(14, 18) +  id.substring(19, 23) + id.substring(24);
        return uuid;
    }
}
