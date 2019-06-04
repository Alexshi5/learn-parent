package com.mengfei.maibao.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2018/9/13
 * description 通用的页面跳转控制器
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{pageName}")
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }

    //获取url中带/的url
    /*@RequestMapping("/**")
    public String toPage(HttpServletRequest request){
        return "/" + this.getExtractPath(request);
    }

    private String getExtractPath(final HttpServletRequest request) {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
    }*/
}
