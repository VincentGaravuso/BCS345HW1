//I certify that this is my own original work - RAM ID: R01656356 - Vincent Garavuso

import java.util.Scanner;


public class BCS345hw1 {
    
    public static void main(String[] args) 
    {
        User user = new User();
        StatementManager SM = new StatementManager();
        Scanner s = new Scanner(System.in);
        
        //Creating Plan Types
        Plan A = new Plan('A',450,0.45,39.99);
        Plan B = new Plan('B',900,0.40,59.99);
        Plan C = new Plan('C',69.99);
        
        
        //Display Menu
        System.out.println("\tMobile Phone Service Plans");
        System.out.println("------------------------------------------");
        System.out.println("Plan A: $39.99 per month. 450 free minutes. \n\tAdditional usage costs $0.45 per minute.");
        System.out.println("Plan B: $59.99 per month. 900 free minutes. \n\tAdditional usage costs $0.40 per minute.");
        System.out.println("Plan C: $69.99 per month. Unlimited minutes.");
        System.out.println("\n\n" + "Enter your full name: ");
        user.name = s.nextLine();
        
        
        boolean illegalCharEntered = true;
        do
        {
            System.out.println("\nWhich plan are you currently using: ");
            user.p.planType = s.nextLine().toUpperCase().charAt(0);
            switch (user.p.getPlanType()) {
                case 'A':
                    user.p = A;
                    illegalCharEntered = false;
                    break;
                case 'B':
                    user.p = B;
                    illegalCharEntered = false;
                    break;
                case 'C':
                    user.p = C;
                    illegalCharEntered = false;
                    break;
                default:
                    System.out.println("\n\n**Illegal Character Entered**\n\n");
                    break;
            }
        }while(illegalCharEntered == true);//loop continues until A B or C is entered
        
        System.out.println("You've entered plan " + user.p.getPlanType());
        
        do
        {
            System.out.println("\nHow many minutes did you use last month: ");
            user.minutesUsed = s.nextDouble();
            if(user.getMinutesUsed() <= 0){
                System.out.println("\n\n**You must enter a positive number.**\n\n");
            }
        }while(user.getMinutesUsed() <= 0);//Loop continues until positive number entered
    
        
        //Gets all plan costs using the users minutesUsed. These three variables are used to compare
        //prices and calculate savings later in the switch statement.
        double PlanA_Bill = SM.calculateBill(user.getMinutesUsed(), A.getMinuteAllowance(),
                A.getOverChargeFee(), A.getMonthlyFee());
        double PlanB_Bill = SM.calculateBill(user.getMinutesUsed(), B.getMinuteAllowance(),
                B.getOverChargeFee(), B.getMonthlyFee());
        double PlanC_Bill = SM.calculateBill(user.getMinutesUsed(), C.getMinuteAllowance(),
                C.getOverChargeFee(), C.getMonthlyFee());
        
        //Calculates users actual bill
        double bill = SM.calculateBill(user.getMinutesUsed(),
                        user.p.getMinuteAllowance(),
                        user.p.getOverChargeFee(),
                        user.p.getMonthlyFee());
        String formattedBill = String.format("%.02f", bill);
        System.out.println("------------------------------------------");
        System.out.println("\tMonthly Statement for " + user.getName() + "\n");
        System.out.println("Plan " + user.p.getPlanType() + " - " + "Minutes used: " + user.getMinutesUsed());
        System.out.println("The charges are $" + formattedBill);
        System.out.println("\nPotential Savings with other plans:");
        
        //These variables are used to display the savings our
        //user would or wouldn't save with each plan.
        double SavingsA=0, SavingsB=0, SavingsC=0;
        switch(user.p.getPlanType())
        {
            case 'A':
                if(PlanB_Bill < PlanA_Bill)//If the bill of plan X is < plan Y, there are potential savings.
                {
                    SavingsB = PlanA_Bill-PlanB_Bill;
                    String f = String.format("%.02f", SavingsB);
                    System.out.println("Plan B: $" + f);
                }
                if(PlanC_Bill < PlanA_Bill)
                {
                    SavingsC = PlanA_Bill-PlanC_Bill;
                    String f = String.format("%.02f", SavingsC);
                    System.out.println("Plan C: $" + f);
                }
                break;
            case 'B':
                if(PlanA_Bill < PlanB_Bill)
                {
                    SavingsA = PlanB_Bill-PlanA_Bill;
                    String f = String.format("%.02f", SavingsA);
                    System.out.println("Plan A: $" + f);
                }
                if(PlanC_Bill < PlanB_Bill)
                {
                    SavingsC = PlanB_Bill-PlanC_Bill;
                    String f = String.format("%.02f", SavingsC);
                    System.out.println("Plan C: $" + f);
                }
                break;
            case 'C':
                if(PlanA_Bill < PlanC_Bill)
                {
                    SavingsA = PlanC_Bill-PlanA_Bill;
                    String f = String.format("%.02f", SavingsA);
                    System.out.println("Plan A: $" + f);
                }
                if(PlanB_Bill < PlanC_Bill)
                {
                    SavingsB = PlanC_Bill-PlanB_Bill;
                    String f = String.format("%.02f", SavingsB);
                    System.out.println("Plan B: $" + f);
                }
                 break;
                 
            default:
                System.out.println("AN ERROR OCCURED");
        }
        
        //If there are no savings, the users current plan is the best for them.
        if(SavingsA == 0 && SavingsB ==0 && SavingsC == 0)
        {
            System.out.println("You chose the best plan.");
        }
        
        System.out.println("\n------------------------------------------" +
                "\n\nPART 2:\n");
        
        for (int i = 32, count = 0; i <= 126; i++)
        {
            if(count % 16 != 0)
            {
                System.out.print((char)i + " ");
                
            }else
                System.out.println((char)i + " ");
            count++;
        }
    }
    
}