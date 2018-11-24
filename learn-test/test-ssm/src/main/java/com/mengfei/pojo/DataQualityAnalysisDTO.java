package com.mengfei.pojo;

/**
 * author Alex
 * date 2018/11/22
 * description 用于传输数据质量分析Word文档属性的POJO类
 */
public class DataQualityAnalysisDTO{

    //数据分析内容
    private String dataAnalysis;

    //数据分析的序号
    private String analysisNum;

    //数据分析的标题
    private String analysisTitle;

    //数据分析的Echarts报表图片的伪地址（使用的是Base64编码）
    private String analysisImgUrl;

    public String getDataAnalysis() {
        return dataAnalysis;
    }

    public void setDataAnalysis(String dataAnalysis) {
        this.dataAnalysis = dataAnalysis;
    }

    public String getAnalysisNum() {
        return analysisNum;
    }

    public void setAnalysisNum(String analysisNum) {
        this.analysisNum = analysisNum;
    }

    public String getAnalysisTitle() {
        return analysisTitle;
    }

    public void setAnalysisTitle(String analysisTitle) {
        this.analysisTitle = analysisTitle;
    }

    public String getAnalysisImgUrl() {
        return analysisImgUrl;
    }

    public void setAnalysisImgUrl(String analysisImgUrl) {
        this.analysisImgUrl = analysisImgUrl;
    }
}
