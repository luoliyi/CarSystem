package cardao;

import Utils.Conn;
import carentity.Car;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public List<Car> getAllCars(){

        List<Car> list=new ArrayList<Car>();
        ResultSet rs= Conn.executeQuery("select * from Car",new Object[]{});
        Car c=null;
        try {
            while (rs.next()){
                c=new Car();
                c.setCid(rs.getInt(1));
                c.setCname(rs.getString(2));
                c.setCcolor(rs.getString(3));
                c.setCspeed(rs.getInt(4));
                c.setCcard(rs.getString(5));
                c.setCdesc(rs.getString(6));
                list.add(c);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Car>getAllCarsByPage(int page,int size){

        int limit=(page-1)*size;

        List<Car> list=new ArrayList<Car>();
        ResultSet rs= Conn.executeQuery("select * from Car limit ?,?",new Object[]{limit,size});
        Car c=null;
        try {
            while (rs.next()){
                c=new Car();
                c.setCid(rs.getInt(1));
                c.setCname(rs.getString(2));
                c.setCcolor(rs.getString(3));
                c.setCspeed(rs.getInt(4));
                c.setCcard(rs.getString(5));
                c.setCdesc(rs.getString(6));
                list.add(c);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Car getOneCar(int cid){
        ResultSet rs= Conn.executeQuery("select * from CarSystem where cid=?",new Object[]{cid});
        Car c=null;
        try {
            while (rs.next()){
                c=new Car();
                c.setCid(rs.getInt(1));
                c.setCname(rs.getString(2));
                c.setCcolor(rs.getString(3));
                c.setCspeed(rs.getInt(4));
                c.setCcard(rs.getString(5));
                c.setCdesc(rs.getString(6));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public int delete(int cid){
        return Conn.executeUpdate("delete from CarSystem where cid=?",new Object[]{cid});
    }
    public int update(Car c){
        return Conn.executeUpdate("update CarSystem set cname=?,ccolor=?,cspeed=?,ccard=?,cdesc=? where cid=?",
                new Object[]{c.getCname(),c.getCcolor(),c.getCspeed(),c.getCcard(),c.getCdesc(),c.getCid()});
    }
    public int insert(Car c){
        return Conn.executeUpdate("insert into CarSystem(cname,ccolor,cspeed,ccard,cdesc) values(?,?,?,?,?)",
                new Object[]{c.getCname(),c.getCcolor(),c.getCspeed(),c.getCcard(),c.getCdesc()});
    }
}
