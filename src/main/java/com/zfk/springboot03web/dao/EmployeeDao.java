package com.zfk.springboot03web.dao;

import com.zfk.springboot03web.pojo.Department;
import com.zfk.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
//员工Dao
@Repository
public class EmployeeDao {
    @Autowired
    private  DepartmentDao departmentDao;
    //模拟数据库中的数据
    private static HashMap<Integer,Employee> employees=null;

    static{
        employees=new HashMap<Integer,Employee>();//船舰一个部门表
        employees.put(1,new Employee(1,"zhang1","10@qq.com",0,new Department(101,"教学部1")));
        employees.put(2,new Employee(2,"zhang2","10@qq.com",0,new Department(102,"教学部2")));
        employees.put(3,new Employee(3,"zhang3","10@qq.com",0,new Department(103,"教学部3")));
        employees.put(4,new Employee(4,"zhang4","10@qq.com",0,new Department(104,"教学部4")));
        employees.put(5,new Employee(5,"zhang5","10@qq.com",0,new Department(105,"教学部5")));

    }
    //主键自增
    private static Integer iniyId=1006;
    //增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(iniyId++);

        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //获取所有员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id获得员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工
    public void delEmployee(Integer id){
        employees.remove(id);
    }
}
