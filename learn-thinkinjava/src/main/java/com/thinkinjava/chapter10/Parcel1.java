package com.thinkinjava.chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * author Alex
 * date 2019/3/24
 * description
 */
public class Parcel1 {
    public void fun(boolean b){
        if(b){
            class Inner{
                Inner(){
                    System.out.println("Inner Initialize");
                }
            }
            new Inner();
        }
        System.out.println("Parcel1.fun()");
    }
}

class Parcel1Test{
    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        parcel1.fun(true);
        //Inner Initialize
        //Parcel1.fun()

        parcel1.fun(false);
        //Parcel1.fun()
    }
}

class MapTest{
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","111");
        map.put("2","222");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> obj : entries){
            System.out.println(obj.getKey() + "==" + obj.getValue());
        }

        int i = 10;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toHexString(i));
    }
}