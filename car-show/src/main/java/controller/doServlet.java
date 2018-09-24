package controller;

import Utils.JsonUtil;
import carentity.Car;
import carentity.Standard;
import carservice.CarBo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/doServlet")
public class doServlet extends BaseServlet {

    CarBo cbo=new CarBo();
    Standard style=null;
    public void getAllCars(HttpServletRequest request,HttpServletResponse response){
        List<Car>getAllCar=cbo.getAllCars();
        style=new Standard(200,"success request!",getAllCar);
        try {
            response.getWriter().print(JsonUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllCarsByPage(HttpServletRequest request,HttpServletResponse response){
        int pageno=Integer.parseInt(request.getParameter("pageno"));
        int size=Integer.parseInt(request.getParameter("size"));
        List<Car>getAllCar=cbo.getAllCarsByPage(pageno,size);
        style=new Standard(200,"success request!",getAllCar);
        try {
            response.getWriter().print(JsonUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCount(HttpServletRequest request,HttpServletResponse response){
        int count=cbo.getAllCars().size();
        try {
            response.getWriter().print(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insert(HttpServletRequest request,HttpServletResponse response){
        Car c=getInfo(request,response);
        try {
            int result=cbo.insert(c);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Car getInfo(HttpServletRequest request,HttpServletResponse response){
        String cname=request.getParameter("cname");
        String ccolor=request.getParameter("ccolor");
        int cspeed=Integer.parseInt(request.getParameter("cspeed"));
        String ccard=request.getParameter("ccard");
        String cdesc=request.getParameter("cdesc");
        return new Car(cname,ccolor,cspeed,ccard,cdesc);
    }

    public  void update(HttpServletRequest request,HttpServletResponse response){

        int cid=Integer.parseInt(request.getParameter("cid"));
        Car c=getInfo(request,response);
        //添加id
        c.setCid(cid);

        try {
            int result=cbo.update(c);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void delete(HttpServletRequest request,HttpServletResponse response){
        int cid=Integer.parseInt(request.getParameter("cid"));
        try {
           int result= cbo.delete(cid);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAll(HttpServletRequest request,HttpServletResponse response){
        String items=request.getParameter("items");
        String[] item=items.split(",");
        int result=0;
        for (int i=0;i<item.length;i++){
            System.out.println(item[i]);
         result+=cbo.delete(Integer.parseInt(item[i]));
        }
        try {
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
