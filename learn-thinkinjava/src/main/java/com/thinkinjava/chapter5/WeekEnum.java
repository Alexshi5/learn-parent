package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/11/1
 * description 使用一星期来演示枚举类的使用
 */
public enum  WeekEnum {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private String notes;

    WeekEnum(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static void main(String[] args) {
        WeekEnum friday = WeekEnum.FRIDAY;
        switch (friday.ordinal()){
            case 0:
                System.out.println("今天" + friday.getNotes());
                break;
            case 1:
                System.out.println("今天" + friday.getNotes());
                break;
            case 2:
                System.out.println("今天" + friday.getNotes());
                break;
            case 3:
                System.out.println("今天" + friday.getNotes());
                break;
            case 4:
                System.out.println("今天" + friday.getNotes());
                break;
            case 5:
                System.out.println("今天" + friday.getNotes());
                break;
            case 6:
                System.out.println("今天" + friday.getNotes());
                break;
        }
    }
}
