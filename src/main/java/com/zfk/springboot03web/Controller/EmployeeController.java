package com.zfk.springboot03web.Controller;

import com.zfk.springboot03web.dao.EmployeeDao;
import com.zfk.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
//
//@Controller
//public class EmployeeController {
//    @Autowired
//    EmployeeDao employeeDao;
//    @RequestMapping("/tables")
//    public String list(Model model){
//        Collection<Employee> employees=employeeDao.getAll();
//        model.addAttribute("emps",employees);
//        return "list";
//    }
//}

//@Controller
//public class TableController {
//    @Autowired
//    EmployeeDao employeeDao;
//    @RequestMapping("/tables")
//
//
//    public String list(Model model){
//        Collection<Employee> employees=employeeDao.getAll();
//        model.addAttribute("emps",employees);
//        return "list";
//    }
//
//}
