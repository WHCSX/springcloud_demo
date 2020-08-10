package com.bjsxt;

import com.bjsxt.service.IDeptService;
import com.bjsxt.vo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest(classes = Dept_8002_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestIDeptService {

    @Autowired
    private IDeptService iDeptService;

    @Test
    public void testGet(){
        System.out.println("【根据deptno查询信息】："+this.iDeptService.get(1L));
    }

    @Test
    public void testAdd(){
        Dept dept = new Dept();
        dept.setDname("旅游部"+System.currentTimeMillis());
        System.out.println("【新增数据行数】："+this.iDeptService.add(dept));
    }

    @Test
    public void testList(){
        List<Dept> deptList = this.iDeptService.list();
        for(Dept dept:deptList){
            System.out.println("【部门信息】："+dept);
        }
    }

}
