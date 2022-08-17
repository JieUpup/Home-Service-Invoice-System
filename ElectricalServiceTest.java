package service.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ElectricalServiceTest {

    @Test
    public void calculateElectricalPrice() {
       ElectricalService electricalService1 = new ElectricalService(HouseSize.SMALL, "test",
                false, 2,false);
       ElectricalService electricalService2 = new ElectricalService(HouseSize.MEDIUM,"test1",
               false,3,false);
        ElectricalService electricalService3 = new ElectricalService(HouseSize.SMALL, "test",
                false, 5,false);
        ElectricalService electricalService4 = new ElectricalService(HouseSize.MEDIUM,"test1",
                false,1,false);

        ElectricalService electricalService5 = new ElectricalService(HouseSize.SMALL, "test",
                false, 2,false);
        ElectricalService electricalService6 = new ElectricalService(HouseSize.MEDIUM,"test1",
                false,2,false);

        System.out.println(electricalService1.serviceFee());
        System.out.println(electricalService2.serviceFee());
        System.out.println(electricalService3.serviceFee());
        System.out.println(electricalService4.serviceFee());



        Assertions.assertEquals(450.0,electricalService1.serviceFee());
        Assertions.assertEquals(650.0,electricalService2.serviceFee());

        Assertions.assertEquals(1050.0,electricalService3.serviceFee());
        Assertions.assertEquals(250.0,electricalService4.serviceFee());





    }
}