package service.model;

public class InteriorPaintService extends Service {
    int hourPaint;

    public InteriorPaintService(HouseSize size, String address, int numOfFloor, int numOfPet) {
        super(size, address,numOfFloor, numOfPet,0,false);
    }

    public double serviceFee() {
        serviceCount++;
        double totalFee = 0.0;
        if (getSize().equals(HouseSize.SMALL) || getSize().equals(HouseSize.MEDIUM)) {
            hourPaint = 16;
        }
        if (getSize().equals(HouseSize.LARGE)) {
            hourPaint = 24;
        }
        totalFee = BASE_RATE * hourPaint;
        if (getNumOfPet() == 1 || getNumOfPet() == 2) {
            totalFee *= 1.05;

        } else if (getNumOfPet() >= 3) {
            totalFee *= 1.07;
        }

        return disCountPrice(totalFee);
    }
}

