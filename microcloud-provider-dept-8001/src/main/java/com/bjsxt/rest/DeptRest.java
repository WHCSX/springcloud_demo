package com.bjsxt.rest;

import com.bjsxt.service.IDeptService;
import com.bjsxt.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class DeptRest {

    @Autowired
    private IDeptService iDeptService;

    @Resource   //进行Eureka的发现服务
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getFallBack") //如果当前的get()方法出现了错误，则执行fallback
    public Object get(@PathVariable("deptno") Long deptno){
        Dept dept = this.iDeptService.get(deptno);
        if(dept==null){
            throw new RuntimeException("部门信息不存在！！！");
        }
        return dept;
    }
    /**
     * 配置Hystrix熔断机制getFallBack()方法
     * 一旦get()方法上抛出了错误的信息，那么就认为该服务有问题，会默认使用“@HystrixCommand”注解之中配置好的fallbackMethod调用类中的指定方法，返回相应数据。
     * @param deptno
     * @return
     */
    public Object getFallBack(@PathVariable("deptno") Long deptno){ //此时方法的参数与get()方法一致
        Dept dept = new Dept(); //设置错误提示
        dept.setDeptno(8001L);
        dept.setDname("【ERROR】microcloud-provider-dept-hystrix-8001");
        dept.setLoc("microcloud-provider-dept-hystrix-8001");
        return dept;
    }

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public Object add(@RequestBody Dept dept){
        return this.iDeptService.add(dept);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public Object list(){
        return this.iDeptService.list();
    }

    /**
     * SpringSecurity(无状态Rest配置)
     * 一个取得session id的方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/dept/sessionId")
    public Object sessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    /**
     * 进行Eureka的发现服务
     * @return
     */
    @RequestMapping(value = "/dept/discover")   //直接返回发现服务信息
    public Object discover(){
        return this.client;
    }

}
