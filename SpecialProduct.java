
public class SpecialProduct extends Goods {

    public SpecialProduct(double price,int quantity,boolean imported){
        super(price,quantity,imported);
    }

    public double getSalesTax(){
        if(super.imported){
            double salesTax = super.salesTaxCalculate(Tax.IMPORT_DUTY);
            return salesTax;
        }
        else{
            return 0;
        }
    }

    public double finalProductCost(){
        double pricevalue = super.priceCalculate();
        return super.roundTo(pricevalue + this.getSalesTax());
    }
}

