package service.model;

/**
 * This program shows how to calculate the electrical  service price
 * It is a subclass derived from PropertyService class.
 * It has one method called  calculateElectricalPrice to calculate the electrical price for the
 * different size of properties.
 */

public class ElectricalService extends Service {
    //constant value for the electrical service
    public static final double BASE_RATE_PER_EMPLOYEE = 200.00;
    public static final double PERMIT_FEE = 50.00;

    private boolean isComplex;
    private int numberOfEmployee;

    public boolean isComplex() {
        return isComplex;
    }

    public void setComplex(boolean complex) {
        isComplex = complex;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) throws IllegalArgumentException {
        if (numberOfEmployee < 1) {
            throw new IllegalArgumentException("Electrical service requires at least one licensed employee");
        }
        if (numberOfEmployee > 4) {
            throw new IllegalArgumentException("The max licenced employee number is 4," +
                    "please contact the company to verify");
        }

        this.numberOfEmployee = numberOfEmployee;
    }

    public ElectricalService(HouseSize size, String address, boolean subMonthly, int numberOfEmployee, boolean isComplex) {
        super(size, address,0,0,0,false);

        this.isComplex = isComplex;
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public double serviceFee() {
        double totalPrice = 0.0;
        if (isComplex) {
            if (getSize().equals(HouseSize.SMALL) || getSize().equals(HouseSize.MEDIUM)){
                getNumberOfEmployee();
                if (getNumberOfEmployee() < 2) {
                    numberOfEmployee = 2;
                }
            }

            if (getSize().equals(HouseSize.LARGE)) {
                if (getNumberOfEmployee() < 3 || getNumberOfEmployee() > 1) {
                    numberOfEmployee = 3;
                }
            }
            return  (BASE_RATE_PER_EMPLOYEE * numberOfEmployee) + PERMIT_FEE;
        } else {
            return  (getNumberOfEmployee() * BASE_RATE_PER_EMPLOYEE) + PERMIT_FEE;
        }
    }
}
