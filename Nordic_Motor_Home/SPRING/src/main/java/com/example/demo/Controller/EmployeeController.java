package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employees")
    public String employees(Model model, String keyword) {
        List<Employee> employeeList = employeeService.fetchAll();
        for (Employee e: employeeList) {
            System.out.println(e);
        }
        model.addAttribute("employees", employeeList);

        if (keyword != null) {
            if(keyword.equals("")) {
                return "redirect:/employees";
            } else {
                model.addAttribute("employees", employeeService.findByKeyWord(keyword));
            }
        }
        else {
            model.addAttribute("employees", employeeService.fetchAll());
        }
        return "home/employees";
    }
}
