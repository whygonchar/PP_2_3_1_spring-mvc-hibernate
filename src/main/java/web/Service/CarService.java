package web.Service;

import web.Model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    List getCars(int count);
}
