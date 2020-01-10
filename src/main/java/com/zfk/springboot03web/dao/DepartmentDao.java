package com.zfk.springboot03web.dao;

import com.zfk.springboot03web.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

//部门dao
@Repository //DepartmentDao被放到了仓库托管 ，其他地方可以用她
public class DepartmentDao {
    //模拟数据库中的数据
    private static HashMap<Integer,Department> departments=null;

    static{
        departments=new HashMap<Integer,Department>();//船舰一个部门表
        departments.put(101,new Department(101,"教学部1"));
        departments.put(102,new Department(102,"教学部2"));
        departments.put(103,new Department(103,"教学部3"));
        departments.put(104,new Department(104,"教学部4"));
        departments.put(105,new Department(105,"教学部5"));
    }
    //获取所有不郁闷信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }
    //通过id获得部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
