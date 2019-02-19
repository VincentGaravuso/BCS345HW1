
public class Plan 
{
    public char planType;
    public double minuteAllowance;
    public double overChargeFee;
    public double monthlyFee;
    
    public Plan(){}
    public Plan(char pt, double ma, double ocf, double mf)
    {
        planType = pt;
        minuteAllowance = ma;
        overChargeFee = ocf;
        monthlyFee = mf;
    }
    public Plan(char pt, double mf)
    {
        planType = pt;
        monthlyFee = mf;
    }
    public char getPlanType()
    {
        return planType;
    }
    public double getMinuteAllowance()
    {
        return minuteAllowance;
    }
    public double getOverChargeFee()
    {
        return overChargeFee;
    }
    public double getMonthlyFee()
    {
        return monthlyFee;
    }
}
