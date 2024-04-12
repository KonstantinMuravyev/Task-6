package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarsController {

    private final CarServiceImpl carServiceImpl;

    public CarsController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String carsPrint(@RequestParam(defaultValue = "5") Integer count,  //принимаем параметр count из запроса с значением по умолчанию равным 5
                            ModelMap model) {               // объект model для передачи данных в представление.
        List<Car> cars = carServiceImpl.getAllCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
