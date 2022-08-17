package service.model;

public class CleanInsideService extends Service {
    int serviceCount;

    public CleanInsideService(HouseSize size, String address, int numOfFloor, int numOfPet, int serviceCount, boolean isSub) {
        super(size, address,0, numOfPet,0,false);
    }
   @Override
    public double serviceFee() {
        serviceCount++;
        double totalFee = 0.0;
        if (getSize().equals(HouseSize.SMALL) || getSize().equals(HouseSize.MEDIUM)) {
            hourClean = 4;
        }
        if (getSize().equals(HouseSize.LARGE)) {
            hourClean = 6;
        }
        totalFee = BASE_RATE * hourClean;
        if (getNumOfPet() == 1 || getNumOfPet() == 2) {
            totalFee *= 1.05;

        } else if (getNumOfPet() >= 3) {
            totalFee *= 1.07;
        }
        return disCountPrice(totalFee);
    }
}

