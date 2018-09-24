package carservice;

import carentity.Car;

import java.util.List;

public interface ICarService {
    List<Car>getAllCars();
    List<Car>getAllCarsByPage(int page,int size);
    Car getOneCar(int cid);
    int insert(Car C);
    int update(Car c);
    int delete(int cid);
}
