package com.thinkinjava.chapter10;

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
