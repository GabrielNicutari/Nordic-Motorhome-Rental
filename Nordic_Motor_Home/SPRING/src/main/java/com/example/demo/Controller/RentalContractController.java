package com.example.demo.Controller;

import com.example.demo.Model.RentalContract;
import com.example.demo.Service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RentalContractController {

    @Autowired
    private RentalContractService rentalContractService;

//    @GetMapping("/")
//    public String index() { return "home/rentalContracts";
//    }

    @GetMapping("/rentalContracts")
    public String rentalContracts(Model model, String keyword) {
        List<RentalContract> rentalContractsList = rentalContractService.fetchAll();
        model.addAttribute("rentalContracts", rentalContractsList);

        if (keyword != null) {
            if(keyword.equals("")) {
                return "redirect:/rentalContracts";
            } else {
                model.addAttribute("rentalContracts", rentalContractService.findByKeyWord(keyword));
            }
        }
        else {
            model.addAttribute("rentalContracts", rentalContractService.fetchAll());
        }
        return "home/rentalContracts";
    }

    @RequestMapping("/rentalContracts/getOne")
    @ResponseBody
    public RentalContract getOne(int id) {
        return rentalContractService.getOne(id);
    }

    @PostMapping(value="/rentalContracts/add")
    public String add(@ModelAttribute RentalContract g) {
        rentalContractService.add(g);
        return "redirect:/rentalContracts";
    }

    @RequestMapping(value="/rentalContracts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    //@GetMapping("/rentalContracts/delete/{id}")
    public String delete(int id) {
        rentalContractService.deleteRow(id);
        return "redirect:/rentalContracts";
    }

    //UPDATE METHOD
    @RequestMapping(value="/rentalContracts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@ModelAttribute RentalContract rentalContract) {
        rentalContractService.update(rentalContract, rentalContract.getId());
        return "redirect:/rentalContracts";
    }

}
