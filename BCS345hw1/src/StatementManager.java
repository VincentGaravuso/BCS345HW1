
public class StatementManager 
{
    public double calculateBill(double minutesUsed, double minutesAllowed, double overChargeFee, double monthlyFee)
    {
        double bill;
        if(minutesAllowed == 0 && overChargeFee == 0)
        {
            bill = monthlyFee;
            return bill;
        }
        
        if(minutesUsed > minutesAllowed)
        {
            bill = (((minutesUsed-minutesAllowed)*overChargeFee)+monthlyFee);
        }
        else   
            bill = monthlyFee;
        
        return bill;
    }
}
