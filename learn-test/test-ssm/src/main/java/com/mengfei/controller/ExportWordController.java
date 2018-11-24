package com.mengfei.controller;

import com.mengfei.pojo.DataQualityAnalysisDTO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author Alex
 * date 2018/11/22
 * description 导出word文档的控制器
 */
@Controller
@RequestMapping("/export/word")
public class ExportWordController {
    private static final String ROOT_PATH = "E:\\test";

    @RequestMapping("/save")
    public void saveImage(String imageName,String imageInfo){
        // 传递过程中  "+" 变为了 " " ，所以需要替换
        String newImageInfo = imageInfo.replaceAll(" ", "+");
        decodeBase64(newImageInfo,new File(ROOT_PATH + File.separator +imageName));
    }

    @RequestMapping("/generate")
    @ResponseBody
    public String generateWord(String imageInfo){
        // 传递过程中  "+" 变为了 " " ，所以需要替换
        String newImageInfo = imageInfo.replaceAll(" ", "+");
        // 数据中：data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABI4AAAEsCAYAAAClh/jbAAA ...  在"base64,"之后的才是图片信息
        String[] arr = newImageInfo.split("base64,");
        //byte[] imgByte = Base64.decodeBase64(arr[1]);
        //文件名
        String wordFileName = "执法总队月报.doc";
        //数据
        Map<String,Object> dataMap = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        dataMap.put("nowDate",format.format(new Date()));
        dataMap.put("dataGeneral","2018年11月共接入数据11类，包含交委数据中心8类，共计接入11202221条数据，未出现异常情况；高速集团3类，共计接入1111111条数据，其中2类正常，高速出入口数据有异常中断情况。");
        dataMap.put("analysisImgUrl",arr[1]);

        List<DataQualityAnalysisDTO> analysisList = new ArrayList<>();
        DataQualityAnalysisDTO analysis = new DataQualityAnalysisDTO();
        analysis.setDataAnalysis("XX数据本月共接入XX条数据，比上月增长XX%，其中过滤清洗xx条。数据接入未出现异常情况。");
        analysis.setAnalysisImgUrl(arr[1]);
        analysis.setAnalysisNum("1");
        analysis.setAnalysisTitle("交调");

        DataQualityAnalysisDTO analysis2 = new DataQualityAnalysisDTO();
        analysis2.setDataAnalysis("XX数据本月共接入XX条数据，比上月增长XX%，其中过滤清洗xx条。数据接入未出现异常情况。");
        analysis2.setAnalysisImgUrl(arr[1]);
        analysis2.setAnalysisNum("2");
        analysis2.setAnalysisTitle("卡口");

        analysisList.add(analysis);
        analysisList.add(analysis2);

        dataMap.put("analysisList",analysisList);

        //调用生成word文档的方法
        //WordUtil.writeWordReport(wordFileName,ROOT_PATH,"test1.ftl",dataMap);
        return "测试成功";
    }


    /**
     * 解析Base64位信息并输出到某个目录下面.
     * @param base64Info base64串
     * @param picPath 生成的文件路径
     * @return 文件地址
     */
    private File decodeBase64(String base64Info, File picPath) {
        if (StringUtils.isEmpty(base64Info)) {
            return null;
        }

        // 数据中：data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABI4AAAEsCAYAAAClh/jbAAA ...  在"base64,"之后的才是图片信息
        String[] arr = base64Info.split("base64,");

        // 将图片输出到系统某目录.
        OutputStream out = null;
        try {
            // 使用了Apache commons codec的包来解析Base64
            byte[] buffer = Base64.decodeBase64(arr[1]);
            out = new FileOutputStream(picPath);
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != out){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return picPath;
    }
}
