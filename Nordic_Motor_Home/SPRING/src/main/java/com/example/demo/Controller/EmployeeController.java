package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Motorhome;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employees")
    public String display(Model model, String keyword) {
        List<Employee> employeeList = employeeService.fetchAll();
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


    @PostMapping(value="/employees/add")
    public String create(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }


    @RequestMapping(value="/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@ModelAttribute Employee employee) {
        employeeService.update(employee, employee.getId());
        return "redirect:/employees";
    }

    @RequestMapping("/employees/getOne")
    @ResponseBody
    public Employee getOne(int id) {
        return employeeService.getOne(id);
    }


    @RequestMapping(value="/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        employeeService.deleteRow(id);
        return "redirect:/employees";
    }
}
