package service.model;

public class Service {
    public static final double BASE_RATE = 80.00;
    public static final double TENTH_DISCOUNT = 0.50;
    public static final double SUB_DISCOUNT = 0.9;

    private HouseSize size;
    public String address;
    public int numOfFloor;
    public int serviceCount;
    public boolean isSub;
    public int hourWash;
    public int hourClean;
    public int hourPaint;
    public int numOfPet;

    public void setSize(HouseSize size) {
        this.size = size;
    }

    public HouseSize getSize() {
        return size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (address == null) {
            throw new IllegalArgumentException("The address is null");
        }
        this.address = address;
    }

    public boolean isSub() {
        return isSub;
    }

    public void setSub(boolean sub) {
        isSub = sub;
    }

    public int getHourClean() {
        return hourClean;
    }

    public void setHourClean(int hourClean) {
        this.hourClean = hourClean;
    }

    public void setHourWash(int hourWash) {
        this.hourWash = hourWash;
    }

    public int getHourWash() {
        return hourWash;
    }

    public int getHourPaint() {
        return hourPaint;
    }

    public void setHourPaint(int hourPaint) {
        this.hourPaint = hourPaint;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) throws IllegalArgumentException {
        if (numOfFloor < 0) {
            throw new IllegalArgumentException("The floor number should not be negative integer ");
        }
        if (numOfFloor > 5) {
            throw new IllegalArgumentException("The maximum number of floors " +
                    "that the company can work with is 5,It should not be possible to create " +
                    "a window cleaning service for a property with more than 3 floors" +
                    "please contact the company to verify");
        }
        this.numOfFloor = numOfFloor;
    }

    public int getNumOfPet() {
        return numOfPet;
    }

    public void setNumOfPet(int numOfPet) throws IllegalArgumentException {
        if (numOfPet < 0) {

            throw new IllegalArgumentException("The pet number should not be negative integer ");
        }
        this.numOfPet = numOfPet;
    }

    public int getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(int serviceCount) throws IllegalArgumentException {
        if (serviceCount < 0) {
            throw new IllegalArgumentException("The service count  should not be negative integer ");
        }
        this.serviceCount = serviceCount;
    }

    public Service(HouseSize size, String address, int numOfFloor, int numOfPet, int serviceCount, boolean isSub) {
        this.size = size;
        this.numOfFloor = numOfFloor;
        this.numOfPet = numOfPet;
        this.address = address;
        this.serviceCount = serviceCount;
        this.isSub = isSub;
    }

    public double disCountPrice(double curPrice) {

        //System.out.println("before discount: " + curPrice);
        if (serviceCount % 10 == 0 && serviceCount > 0) {
            // System.out.println("10% : " + curPrice * TENTH_DISCOUNT);
            return curPrice * TENTH_DISCOUNT;
        }
        if (isSub) {
            //System.out.println("Monthly : " + curPrice * SUB_DISCOUNT);
            return curPrice * SUB_DISCOUNT;
        }
        //System.out.println("No discount : " + curPrice * SUB_DISCOUNT);
        return curPrice;
    }

    public double serviceFee() {
        return 0;
    }

}