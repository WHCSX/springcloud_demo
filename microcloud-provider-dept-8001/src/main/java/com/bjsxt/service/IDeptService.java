package com.bjsxt.service;

import com.bjsxt.vo.Dept;

import java.util.List;

public interface IDeptService {

    Dept get(Long deptno);

    Boolean add(Dept dept);

    List<Dept> list();

}
