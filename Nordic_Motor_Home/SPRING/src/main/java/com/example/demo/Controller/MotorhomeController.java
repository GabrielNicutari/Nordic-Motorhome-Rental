package com.example.demo.Controller;

import com.example.demo.Model.Brand;
import com.example.demo.Model.Motorhome;
import com.example.demo.Service.MotorhomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MotorhomeController {

    @Autowired
    private MotorhomeService motorhomeService;

//    @GetMapping("/")
//    public String index() {
//        return "home/motorhomes";
//    }

    @GetMapping("/motorhomes")
    public String motorhomes(Model model, String keyword) {
        List<Motorhome> motorhomeList = motorhomeService.fetchAll();
        List<Brand> brandList = motorhomeService.fetchBrands();
        List<com.example.demo.Model.Model> modelList = motorhomeService.fetchModels();
        model.addAttribute("motorhomes", motorhomeList);
        model.addAttribute("brands",brandList);
        model.addAttribute("models",modelList);

        if (keyword != null) {
            if(keyword.equals("")) {
                return "redirect:/motorhomes";
            } else {
                model.addAttribute("motorhomes", motorhomeService.findByKeyWord(keyword));
            }
        }
        else {
            model.addAttribute("motorhomes", motorhomeService.fetchAll());
        }
        return "home/motorhomes";
    }

    @RequestMapping("/motorhomes/getOne")
    @ResponseBody
    public Motorhome getOne(int id) {
        return motorhomeService.getOne(id);
    }

    @PostMapping(value="/motorhomes/add")
    public String add(@ModelAttribute Motorhome g) {
        motorhomeService.add(g);
        return "redirect:/motorhomes";
    }

    @RequestMapping(value="/motorhomes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    //@GetMapping("/motorhomes/delete/{id}")
    public String delete(int id) {
        motorhomeService.deleteRow(id);
        return "redirect:/motorhomes";
    }

//    UPDATE METHOD
    @RequestMapping(value="/motorhomes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@ModelAttribute Motorhome motorhome) {
        motorhomeService.update(motorhome, motorhome.getId());
        return "redirect:/motorhomes";
    }
}
