public class Goods {
    protected double price;
    protected int quantity;
    protected boolean imported;

    public Goods(double price,int quantity,boolean imported){
        this.price = price;
        this.quantity = quantity;
        this.imported = imported;
    }

    protected double priceCalculate(){
        return quantity * price;
    }
    
    protected double salesTaxCalculate(double tax){
        return (tax/100)*price;
    }

    // method to round the deciamal value close to 0.50
    protected double roundTo(double value) {
        double temp = value * 100;
        if (temp == (int) temp) {
            return value;
        } else {
            String numberInString = String.valueOf(temp);
            char numberAfterDecimal = numberInString.charAt(numberInString.indexOf(".") + 1);
            if (Character.getNumericValue(numberAfterDecimal) <= 5) {
                return Math.ceil(value / 0.05) * 0.05;
            } else {
                return Math.round(Double.parseDouble(numberInString)) / 100.0;
            }
        }

    }
}