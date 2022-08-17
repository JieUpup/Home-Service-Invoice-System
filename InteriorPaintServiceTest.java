package service.model;

import org.junit.jupiter.api.Test;

class InteriorPaintServiceTest {

    @Test
    public void calculatePaintingFee() {
        InteriorPaintService interiorPaintService = new InteriorPaintService(HouseSize.SMALL,"test",1,1);
        InteriorPaintService interiorPaintService1 = new InteriorPaintService(HouseSize.LARGE,"test1",1,1);
        System.out.println(interiorPaintService.serviceFee());
        System.out.println(interiorPaintService1.serviceFee());
    }
}