package elipongaoperator;

public class ElipongaOperator {

    public static void main(String[] args) {
        
        String fullName = "Vrixzandro Eliponga";
                
        double grossPay = 40000.0;
        final double tax = 0.15;
        final double SSS = 0.0363;
        final double Medicare = 0.0125;
        final double pag_ibig = 100.0;
        
        double deduct_Tax, deduct_SSS, deduct_Medicare, netPay;
        
        deduct_Tax = grossPay * tax;
        deduct_SSS = grossPay * SSS;
        deduct_Medicare = grossPay * Medicare;
        
        netPay = grossPay - (deduct_Tax + deduct_SSS + deduct_Medicare + pag_ibig);
        
        System.out.println("Employee Name:          " + fullName);
        System.out.println("Gross Pay:              " + grossPay);
        System.out.println("-------------------------------------------");
        System.out.println("Deductions              Amount");
        System.out.println("Witholding tax:         " + deduct_Tax);
        System.out.println("SSS Contribution:       " + deduct_SSS);
        System.out.println("Medicare:               " + deduct_Medicare);
        System.out.println("Pagibig Contribution:   " + pag_ibig);
        System.out.println("-------------------------------------------");
        System.out.println("Net Pay:                " + netPay);
    }
    
}
