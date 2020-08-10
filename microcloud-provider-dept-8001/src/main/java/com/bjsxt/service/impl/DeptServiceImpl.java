package com.bjsxt.service.impl;

import com.bjsxt.dao.IDeptDao;
import com.bjsxt.service.IDeptService;
import com.bjsxt.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDeptService")
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public Dept get(Long deptno) {
        return this.deptDao.selectByDeptno(deptno);
    }

    @Override
    public Boolean add(Dept dept) {
        return this.deptDao.insert(dept);
    }

    @Override
    public List<Dept> list() {
        return this.deptDao.selectAll();
    }
}
