package com.wm.util;

public class StringUtil {
    public static  boolean isNotEmpty(String str){      //�ж��ַ����Ƿ�Ϊ����
        if (!"".equals(str) && str!=null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmpty(String str){          //�ж��ַ����Ƿ�Ϊ��
        if ("".equals(str) || str==null){
            return true;
        }else {
            return false;
        }
    }
}
