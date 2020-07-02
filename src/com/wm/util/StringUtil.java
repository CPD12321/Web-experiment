package com.wm.util;

public class StringUtil {
    public static  boolean isNotEmpty(String str){      //ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª²»¿Õ
        if (!"".equals(str) && str!=null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmpty(String str){          //ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
        if ("".equals(str) || str==null){
            return true;
        }else {
            return false;
        }
    }
}
