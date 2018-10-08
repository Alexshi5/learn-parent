package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/9/30
 * description 用于描述预警类型和工单子类型之间映射关系的枚举类
 */
public enum WarnEnum {
    NOUN_TRAFFICSPEED(91, "交调小时平均速度预警"),
    NOUN_BAYONETSPEED(90, "卡口小时平均速度预警"),
    NOUN_EVENT(101, "异常事件预警"),
    NOUN_TRAFFICFLOW_DAY(13, "交调当日流量预警"),
    NOUN_TRAFFICFLOW_HOURE(11, "交调小时流量"),
    NOUN_BAYONETFLOW_HOURE(10, "卡口小时流量预警"),
    NOUN_BAYONETFLOW_DAY(12, "卡口当日流量预警"),
    NOUN_FOG(65, "大雾预警"),
    NOUN_RAIN(64, "暴雨预警"),
    NOUN_ORTHER(20, "其他预警"),
    NOUN_CARRUN(62, "车辆异常上道预警"),
    NOUN_DEVICE(4, "设备预警");

    private int factValue;

    private String optname;

    WarnEnum(int factValue, String optname) {
        this.factValue = factValue;
        this.optname = optname;
    }

    public int getFactValue() {
        return factValue;
    }

    public void setFactValue(int factValue) {
        this.factValue = factValue;
    }

    public String getOptname() {
        return optname;
    }

    public void setOptname(String optname) {
        this.optname = optname;
    }
}
