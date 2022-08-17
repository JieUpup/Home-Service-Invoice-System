package service.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExteriorWindowWashingServiceTest {

    @Test
    public void calculateCleanWindowFee() {
        ExteriorWindowWashingService exteriorWindowWashingService = new ExteriorWindowWashingService(HouseSize.SMALL,"TEST"
        ,0,1,0, false, false);

        ExteriorWindowWashingService exteriorWindowWashingService1 = new ExteriorWindowWashingService(HouseSize.LARGE,"TEST"
                ,0,1,0,false, false );
        ExteriorWindowWashingService exteriorWindowWashingService2 = new ExteriorWindowWashingService(HouseSize.LARGE,"TEST"
                ,1,3 ,0, false, false);
        ExteriorWindowWashingService exteriorWindowWashingService3 = new ExteriorWindowWashingService(HouseSize.LARGE,"TEST"
                ,3,5 ,0,false, false);





        Assertions.assertEquals(80.0, exteriorWindowWashingService.serviceFee());
        Assertions.assertEquals(320.0, exteriorWindowWashingService1.serviceFee());
        Assertions.assertEquals(320.0, exteriorWindowWashingService2.serviceFee());
        Assertions.assertEquals(336.0, exteriorWindowWashingService3.serviceFee());






    }
}