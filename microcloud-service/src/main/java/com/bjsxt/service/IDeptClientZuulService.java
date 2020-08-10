package com.bjsxt.service;

import com.bjsxt.component.IDeptClientServiceFallbackFactory;
import com.bjsxt.config.FeignClientConfig;
import com.bjsxt.config.FeignClientZuulConfig;
import com.bjsxt.vo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientZuulConfig.class,fallbackFactory = IDeptClientServiceFallbackFactory.class)
public interface IDeptClientZuulService {

    @RequestMapping(value = "/mldn-proxy/dept-proxy/dept/get/{deptno}",method = RequestMethod.GET)
    Dept get(@PathVariable("deptno") Long deptno);

    /**
     * 此处并没有使用@RequestBody注解
     * @param dept
     * @return
     */
    @RequestMapping(value = "/mldn-proxy/dept-proxy/dept/add",method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value = "/mldn-proxy/dept-proxy/dept/list",method = RequestMethod.GET)
    List<Dept> list();

}
