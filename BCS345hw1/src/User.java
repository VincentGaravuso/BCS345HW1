
public class User 
{
    public String name;
    public double minutesUsed;
    public Plan p = new Plan();
    
    public User(){}
    public User(String n, double m,Plan pl){
        this.name = n;
        this.minutesUsed = m;
        this.p = pl;
        
    }
    
    public String getName()
    {
        return name;
    }
    public double getMinutesUsed()
    {
        return minutesUsed;
    }
}
