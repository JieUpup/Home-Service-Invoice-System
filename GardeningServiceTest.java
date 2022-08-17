package service.model;

import org.junit.jupiter.api.Test;

class GardeningServiceTest {


    @Test
    public void calculatePrice() {
        GardeningService gardeningService = new GardeningService(HouseSize.SMALL,"test1",
                false,true);
        System.out.println(gardeningService.serviceFee());

        GardeningService gardeningService1 = new GardeningService(HouseSize.SMALL,"test1",
                true, false );

        System.out.println(gardeningService1.serviceFee());
        System.out.println(gardeningService.serviceFee());


    }
}