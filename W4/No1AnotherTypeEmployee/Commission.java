package No1AnotherTypeEmployee;

public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate); // call superclass constructor
        this.commissionRate = commissionRate; // set commission rate
        totalSales = 0; // initialize total sales to zero
    }
    
    public void addSales(double totalSales) {
        this.totalSales += totalSales; // accumulate total sales
    }
    
    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate); // calculate total pay including commission 
        totalSales = 0; // reset sales for next period
        return payment; 
    }

    public String toString() {
        String result = super.toString(); // get string from superclass for basic employee info
        result += "\nTotal Sales: " + totalSales; // add total sales to string for
        result += "\nCommission Rate: " + commissionRate; // add commission rate to string
        return result;
    }
}
