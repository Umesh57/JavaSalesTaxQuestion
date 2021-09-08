public class Tax {
    // Types of tax in percentage
    static double salesTax = 10.00;
    static double importDuty = 5.00;

    public double taxCalculate(Boolean specialCategory, boolean imported, double price) {
        //System.out.println(price);
        if (specialCategory) {
           // System.out.println("Special Product");
            if (imported) {
             //   System.out.println("Imported Product");
                return (importDuty / 100) * price;
            } else {
               // System.out.println("Not imported Product");
                return 0;
            }
        } else {
            //System.out.println("ordinary Product");
            if (imported) {
              //  System.out.println("Imported Product");
                return ((salesTax + importDuty) / 100) * price;
            } else {
                //System.out.println("Not Imported Product");
                return (salesTax / 100) * price;
            }
        }
    }

    // public static void main(String args[]) {
    //     Tax t1 = new Tax();
    //     // System.out.println(t1.roundTo(11.8125));
    //     // System.out.println(t1.roundTo(54.625));
    //     // System.out.println(t1.roundTo(32.1885));
    //     // System.out.println(t1.roundTo(32.567));

    //     System.out.println(t1.taxCalculate(true, true, 12.49));
    //     System.out.println(t1.taxCalculate(false, false, 14.99));
    //     System.out.println(t1.taxCalculate(true, true, 10.00));
    //     System.out.println(t1.taxCalculate(false, true, 47.50));
    // }
}
