package com.fcbrains.xinruikeji;

/**
 * Created by dell-pc on 2016/5/5.
 */
public class MyLogUtils {
    private static boolean kaiguan = true;
    public static void syso(String str){
        if (kaiguan){
            System.out.println("-----" + str);
        }
    }
}
