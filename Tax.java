public class Tax {
    // Types of tax in percentage
    static double salesTax = 10.00;
    static double importDuty = 5.00;

    public double taxCalculate(Boolean specialCategory, boolean imported, double price) {
        if (specialCategory) {
            if (imported) {
                return (importDuty / 100) * price;
            } else {
                return 0;
            }
        } else {
            if (imported) {
                return ((salesTax + importDuty) / 100) * price;
            } else {
                return (salesTax / 100) * price;
            }
        }
    }
}
