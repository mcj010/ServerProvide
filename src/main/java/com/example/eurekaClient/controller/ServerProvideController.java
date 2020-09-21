package com.example.eurekaClient.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.eurekaClient.model.TestModel;

@RestController
public class ServerProvideController {
    //描述eureka客户端信息的类
    @Autowired
    private DiscoveryClient eurekaClient;
    
    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value="/ServerTest", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public TestModel getTest(HttpServletRequest request){
        TestModel tm = new TestModel();
        tm.setUrl(request.getRequestURL().toString());
        tm.setMsg("请求访问成功");
        logger.info("ServerProvideController");
        return tm;
    }
}
