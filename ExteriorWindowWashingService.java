package service.model;

public class ExteriorWindowWashingService extends Service {
    public ExteriorWindowWashingService(HouseSize size, String address, int  numOfFloor, int numOfPet, int serviceCount,
                                        boolean isSub, boolean subMonthly) {
        super(size, address,numOfFloor,0,0, false);
    }

    @Override
    public double serviceFee() {
        double totalPrice = 0.0;

        serviceCount++;
        if (getSize().equals(HouseSize.SMALL)) {
            hourClean = 1;
        }
        if (getSize().equals(HouseSize.MEDIUM)) {
            hourClean = 2;
        }
        if (getSize().equals(HouseSize.LARGE)) {
            hourClean = 4;
        }

        totalPrice = BASE_RATE * hourClean;

        if (numOfFloor == 2 || numOfFloor == 3) {
            totalPrice *= 1.05;
        }
        if (numOfFloor > 3) {
            throw new IllegalArgumentException("The max floor number is 3,please contact the company to verify");
        }

        return totalPrice;
    }
}

