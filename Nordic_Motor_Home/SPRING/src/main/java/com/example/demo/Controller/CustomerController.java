package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*@GetMapping("/")
    public String index() {
        return "home/customers";
    }*/

    @GetMapping("/customers")
    public String customers(Model model, String keyword) {
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);

        if (keyword != null) {
            if(keyword.equals("")) {
                return "redirect:/customers";
            } else {
                model.addAttribute("customers", customerService.findByKeyWord(keyword));
            }
        }
        else {
            model.addAttribute("customers", customerService.fetchAll());
        }
        return "home/customers";
    }

    @RequestMapping("/customers/getOne")
    @ResponseBody
    public Customer getOne(int id) {
        return customerService.getOne(id);
    }

    @PostMapping(value="/customers/add")
    public String add(@ModelAttribute Customer c) {
        customerService.add(c);
        return "redirect:/customers";
    }

    @RequestMapping(value="/customers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    //@GetMapping("/customers/delete/{id}")
    public String delete(int id) {
        customerService.deleteRow(id);
        return "redirect:/customers";
    }

    //UPDATE METHOD
    @RequestMapping(value="/customers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@ModelAttribute Customer c) {
        customerService.update(c, c.getId());
        return "redirect:/customers";
    }

}
