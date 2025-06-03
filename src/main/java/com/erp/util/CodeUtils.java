package com.erp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUtils {
    //产生商品的编码
    public static String toItemCode(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    public static void main(String[] args){
        String code = toItemCode();
        System.out.println(code);
    }
}
