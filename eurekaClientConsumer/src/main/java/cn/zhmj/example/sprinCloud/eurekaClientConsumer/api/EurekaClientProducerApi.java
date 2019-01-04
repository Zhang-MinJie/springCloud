package cn.zhmj.example.sprinCloud.eurekaClientConsumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eurekaClientProducer")
public interface EurekaClientProducerApi {
	
	@RequestMapping(method = RequestMethod.GET, value = "/hellow")
    public String hellow();
}
