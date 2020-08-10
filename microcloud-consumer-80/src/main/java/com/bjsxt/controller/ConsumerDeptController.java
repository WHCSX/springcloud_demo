package com.bjsxt.controller;

import com.bjsxt.service.IDeptClientService;
import com.bjsxt.service.IDeptClientZuulService;
import com.bjsxt.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerDeptController {

    /*private static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
    private static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add";
    private static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list";*/

    /**
     * 有了Ribbon与Eureka整合之后用户不再去关注具体的Rest服务的地址与端口号了，所有的信息获取都通过Eureka完成
     * 现在在Eureka之中注册的所有服务的名称都是大写字母：MICROCLOUD-PROVIDER-DEPT
     */
    /*private static final String DEPT_GET_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/get/";
    private static final String DEPT_ADD_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/add";
    private static final String DEPT_LIST_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/list";*/

    /*@Autowired
    private RestTemplate restTemplate;*/

    /*@Autowired
    private HttpHeaders headers;*/

    /**
     * 通过Feign定义接口来实现业务的操作
     */
    /*@Resource
    private IDeptClientService deptClientService;*/

    /**
     * 在原有基础通过Zuul网关定义接口来实现业务的操作
     */
    @Resource
    private IDeptClientZuulService iDeptClientZuulService;

    @RequestMapping("/consumer/dept/get")
    public Object getDept(Long deptno){
//        Dept dept = this.restTemplate.getForObject(DEPT_GET_URL + deptno, Dept.class);
//        Dept dept = this.restTemplate.exchange(DEPT_GET_URL + deptno
//                                                    , HttpMethod.GET
//                                                    , new HttpEntity<Object>(this.headers)
//                                                    , Dept.class).getBody();
        return this.iDeptClientZuulService.get(deptno);
    }

    @RequestMapping("/consumer/dept/add")
    public Object addDept(Dept dept){
//        Boolean flag = this.restTemplate.postForObject(DEPT_ADD_URL,dept, boolean.class);
//        Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL
//                                                    , HttpMethod.POST
//                                                    , new HttpEntity<Object>(dept,this.headers)
//                                                    , Boolean.class).getBody();
        return this.iDeptClientZuulService.add(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public Object listDept(){
//        List depts = this.restTemplate.getForObject(DEPT_LIST_URL, List.class);
//        List depts = this.restTemplate.exchange(DEPT_LIST_URL
//                                                    , HttpMethod.GET
//                                                    , new HttpEntity<Object>(this.headers)
//                                                    , List.class).getBody();
        return this.iDeptClientZuulService.list();
    }

}
