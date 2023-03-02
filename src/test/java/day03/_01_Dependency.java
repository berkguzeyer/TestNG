package day03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar(){
        System.out.println("Car has started.");
//        Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
        void driveCar(){
            System.out.println("Car is driven.");
    }

    @Test(dependsOnMethods = {"startCar","driveCar"})
    void parkCar(){
        System.out.println("Car is parked.");
    }

    @Test(dependsOnMethods = {"parkCar", "driveCar", "startCar"})
    void stopCar(){
        System.out.println("Car has stopped.");
    }


}
