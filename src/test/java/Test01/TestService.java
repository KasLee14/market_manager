package Test01;

import lan.pojo.Dept;
import lan.pojo.Supermarket;
import lan.service.DeptService;
import lan.service.SupermarketService;
import org.junit.Test;

public class TestService {
    @Test
    public void Test01(){
        Supermarket supermarket = new Supermarket("PS2902","西大街商场","QWE","456789321");
        SupermarketService supermarketService = new SupermarketService();
        try {
            supermarketService.insert(supermarket);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("wrong");
        }
    }

    @Test
    public void Test02() {
        DeptService deptService = new DeptService();
        Dept dept = deptService.selectByName("淮海商场", "后勤部");
        System.out.println(dept);
    }
}
