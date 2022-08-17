package service.model;

public class GardeningService extends Service {
    int hourGarden;
    /*
     * constant value for the gardening class.
     */
    public static final double BASE_RATE_PER_HOUR = 80.00;
    public static final double REMOVAL_WASTE_FEE = 20.00;
    //constructor
    public GardeningService(HouseSize size, String address,
                            boolean isSub, boolean subMonthly) {
        super(size, address,0,0,0,isSub);
    }

    //method to calculatePrice for the garden service
     @Override
    public double serviceFee(){
        double totalPrice = 0.0;
        if(getSize().equals(HouseSize.SMALL) || getSize().equals(HouseSize.MEDIUM)){
            hourGarden = 3;
        }
        if(getSize().equals(HouseSize.LARGE)){
            hourGarden = 6;
        }
        totalPrice = (hourGarden * BASE_RATE_PER_HOUR ) + REMOVAL_WASTE_FEE;

        return disCountPrice(totalPrice);
    }
}