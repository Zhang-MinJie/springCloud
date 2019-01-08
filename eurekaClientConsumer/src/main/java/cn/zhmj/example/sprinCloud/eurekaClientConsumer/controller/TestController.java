package cn.zhmj.example.sprinCloud.eurekaClientConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.zhmj.example.sprinCloud.eurekaClientConsumer.api.EurekaClientProducerApi;

@RestController
public class TestController {
	@Autowired
	private EurekaClientProducerApi eurekaClientProducerApi;

	@HystrixCommand(
			fallbackMethod = "buildFallback",
			threadPoolKey = "licenseByOrgThreadPool",
			threadPoolProperties = {
			        @HystrixProperty(name = "coreSize",value="30"),
			        @HystrixProperty(name="maxQueueSize", value="10")
			    },
			    commandProperties = {
			        @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),
			        @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
			        @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
			        @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value="15000"),
			        @HystrixProperty(name="metrics.rollingStats.numBuckets",value="5"),
			        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
			    }
		)
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String home() {
		return eurekaClientProducerApi.hello();
	}
	
	public String buildFallback() {
		return "Say hello word Error";
	}
}
