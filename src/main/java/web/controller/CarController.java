package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String cars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "car";
    }

    @GetMapping("/{count}")
    public String show(@PathVariable("count") int count, Model model) {
        model.addAttribute("car", carService.getCars(count));
        return "carIndex";
    }


}
