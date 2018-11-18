package com.mengfei.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author Alex
 * date 2018/11/12
 * description 用于应用程序的配置文件设置
 */
@Component
public class ApplicationPropertiesTest {

    @Value("${test.title}")
    private String testTitle;

    @Value("${test.description}")
    private String testDescription;

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }
}
