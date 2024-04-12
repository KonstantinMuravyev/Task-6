package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getAllCars(Integer count) {
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("Mercedes Benzene", "Black", 1999));
        carList.add(new Car("Toyota Rav4", "White", 2012));
        carList.add(new Car("Honda Civic", "Blue", 2009));
        carList.add(new Car("Haval H6", "Brown", 2020));
        carList.add(new Car("Suzuki Escudo", "Black", 1997));

        // создаем поток из carlist, ограничиваем кол-во элементов до limit(count),
        // собираем данные в коллекцию(в лист)
        return carList.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
