package com.bjsxt.dao;

import com.bjsxt.vo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //这个注释在SpringCloud中不能遗漏，否则MyBatis将无法找到映射路径
public interface IDeptDao {

    Dept selectByDeptno(Long deptno);

    Boolean insert(Dept dept);

    List<Dept> selectAll();

}
