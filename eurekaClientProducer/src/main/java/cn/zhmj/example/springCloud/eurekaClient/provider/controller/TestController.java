package cn.zhmj.example.springCloud.eurekaClient.provider.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TestController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
    public String home() {
        return "Hello world";
    }
}
