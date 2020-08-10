package com.bjsxt.component;

import com.bjsxt.service.IDeptClientService;
import com.bjsxt.service.IDeptClientZuulService;
import com.bjsxt.vo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断机制-服务降级（服务的降级处理是在客户端实现的，与你的服务器端没有关系。）
 * 使用Zuul路由之后，将原来的IDeptClientService改为IDeptClientZuulService，才能实现客户端的服务降级处理
 * @author chenshuaixin
 * @date 2020/8/8 - 14:24
 */
@Component
public class IDeptClientServiceFallbackFactory implements FallbackFactory<IDeptClientZuulService> {
    @Override
    public IDeptClientZuulService create(Throwable throwable) {
        return new IDeptClientZuulService() {
            @Override
            public Dept get(Long deptno) {
                Dept dept = new Dept(); //设置错误提示
                dept.setDeptno(8888L);
                dept.setDname("【ERROR】Feign-Hystrix");
                dept.setLoc("Consumer客户端提供");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
