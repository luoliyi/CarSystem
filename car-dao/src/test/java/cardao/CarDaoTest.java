package cardao;

import carentity.Car;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CarDaoTest {


    @Test
    public void getAllCars() {
        CarDao cdao=new CarDao();
        Assert.assertNotSame(0,cdao.getAllCars().size());
    }

    @Test
    public void getAllCarsByPage() {
        CarDao cdao=new CarDao();
       List<Car>list= cdao.getAllCarsByPage(2,2);
       for (Car c:list){
           System.out.println(c.toString());
       }

    }
}
