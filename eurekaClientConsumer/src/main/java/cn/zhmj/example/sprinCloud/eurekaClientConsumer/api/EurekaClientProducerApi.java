package cn.zhmj.example.sprinCloud.eurekaClientConsumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client-producer")
public interface EurekaClientProducerApi {
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello();
}
