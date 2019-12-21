package com.lwb.springbootcrud.controller;

import com.lwb.springbootcrud.dao.EmployeeDao;
import com.lwb.springbootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2019-12-04 23:00
 **/
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();

        model.addAttribute("emps", all);
        return "emp/list";
    }

}
