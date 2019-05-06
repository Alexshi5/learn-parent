package com.mengfei.springboot.testdocker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping("/hello")
    public ResponseEntity<String> helloDocker(){
        return ResponseEntity.ok("OK");
    }
}
