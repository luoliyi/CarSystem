package carservice;

import cardao.CarDao;
import carentity.Car;

import java.util.List;

public class CarBo implements ICarService {

    CarDao cdao=new CarDao();

    public List<Car> getAllCars() {
        return cdao.getAllCars();
    }

    public List<Car> getAllCarsByPage(int page, int size) {
        return cdao.getAllCarsByPage(page,size);
    }

    public Car getOneCar(int cid) {
        return cdao.getOneCar(cid);
    }

    public int insert(Car c) {
        return cdao.insert(c);
    }

    public int update(Car c) {
        return cdao.update(c);
    }

    public int delete(int cid) {
        return cdao.delete(cid);
    }
}
