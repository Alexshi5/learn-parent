package com.thinkinjava.chapter3;

/**
 * author Alex
 * date 2018/6/12
 * description 组装in和or的SQL
 */
public class Example15  {
    public static void main(String[] args) {
        int size = 1000;
        String inSQL = "";
        for(int i = 0;i<size;i++){
            if(i==size-1){
                inSQL += "select "+i+","+i+" from dual ";
            }else {
                inSQL += "select "+i+","+i+" from dual union ";
            }
        }
        String inFinalSQL = "insert into test(oid,tage) select * from ("+inSQL+")";
        System.out.println(inFinalSQL);

        String orSQL = "";
        for(int j = 0;j<size;j++){
            if(j==size-1){
                orSQL += "tage = "+j;
            }else {
                orSQL += "tage = "+j+" or ";
            }
        }
        String orFinalSQL = "select * from test where "+orSQL;
        System.out.println(orFinalSQL);
    }
}
