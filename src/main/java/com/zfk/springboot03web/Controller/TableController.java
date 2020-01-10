package com.zfk.springboot03web.Controller;

import com.zfk.springboot03web.dao.DepartmentDao;
import com.zfk.springboot03web.dao.EmployeeDao;
import com.zfk.springboot03web.pojo.Department;
import com.zfk.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.Collection;

@Controller
public class TableController {
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping("/tables")
        public String list(Model model){
            System.out.println("tablecontroller");
            Collection<Employee> employees=employeeDao.getAll();
            model.addAttribute("emps",employees);
            return "tables";
        }
    @GetMapping("/emp/table")
        public String toAddpage(Model model){
            //查出所有部门信息
            Collection<Department> departments=departmentDao.getDepartment();
            model.addAttribute("departments",departments);
            return "/emp/user-profile-lite";
    }
    @PostMapping("/emp/table")
    public String addEmp(Employee employee){
        System.out.println("添加员工："+employee);
        //添加操作
        employeeDao.save(employee);//调用底层业务方法保存员工信息;
        return "redirect:/tables";  //重定向到首页  重定向不用加.html
    }
    //去员工的修改页面
    @GetMapping("/emp/{id}")  // 如果是@GetMapping("/XXX/{id}") 则return的页面找css文件 会去找/xxx/css/aa.css  很奇怪
                                //解决方案 在对应页面的静态资源加个 “../”就能访问了
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        System.out.println("id"+id);

        //查出原来的数据
        Employee employeebyid= employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeebyid);
        System.out.println("employeebyid"+employeebyid);
        //查出所有部门信息
        Collection<Department> departments=departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        System.out.println("departments"+departments);
       return "emp/update";//去修改页面
    }
    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee ){
        employeeDao.save(employee);

        return "redirect:/tables";  //重定向到首页
    }
    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
         employeeDao.delEmployee(id);

        return "redirect:/tables";
    }
}
