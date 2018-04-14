package http.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2018/4/12
 * description
 */
@Controller
@RequestMapping("/http")
public class HttpRequestController {
    @RequestMapping("/test/")
    public void beginTest() {
        System.out.println("This is request test!");
    }
}
