package cn.zhmj.example.sprinCloud.eurekaClientConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zhmj.example.sprinCloud.eurekaClientConsumer.api.EurekaClientProducerApi;

@RestController
public class TestController {
    @Autowired
    private EurekaClientProducerApi eurekaClientProducerApi;
	
	@RequestMapping(value = "/hellow", method = RequestMethod.GET)
	@ResponseBody
    public String home() {
		return eurekaClientProducerApi.hellow();
    }
}
