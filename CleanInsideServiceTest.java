package service.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CleanInsideServiceTest {

    @Test
    void calculateCleanInsideFee() {
        CleanInsideService cleanInside1 = new CleanInsideService(HouseSize.SMALL, "test",
                2, 2, 0, false);
        CleanInsideService cleanInside2 = new CleanInsideService(HouseSize.MEDIUM,"test1",
                1,5,0,false);



        CleanInsideService cleanInside3 = new CleanInsideService(HouseSize.LARGE,"test2",
                1,1,0,false);

        CleanInsideService cleanInside4 = new CleanInsideService(HouseSize.SMALL, "test",
                0, 0, 0, false);
        CleanInsideService cleanInside5 = new CleanInsideService(HouseSize.MEDIUM,"test1",
                1,10,0,true);
        CleanInsideService cleanInside6 = new CleanInsideService(HouseSize.MEDIUM,"test2",
                3,0,0,false);

        System.out.println(cleanInside1.serviceFee());
        System.out.println(cleanInside2.serviceFee());
        System.out.println(cleanInside3.serviceFee());
        System.out.println(cleanInside4.serviceFee());
        System.out.println(cleanInside5.serviceFee());
        System.out.println(cleanInside6.serviceFee());



        Assertions.assertEquals(336.0,cleanInside1.serviceFee());
        Assertions.assertEquals(342.40000000000003,cleanInside2.serviceFee());
        Assertions.assertEquals(504.0,cleanInside3.serviceFee());
        Assertions.assertEquals(320.0,cleanInside4.serviceFee());
        Assertions.assertEquals(342.40000000000003,cleanInside5.serviceFee());
        Assertions.assertEquals(320.0,cleanInside6.serviceFee());



    }
}