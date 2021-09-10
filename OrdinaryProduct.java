
public class OrdinaryProduct extends Goods {

    public OrdinaryProduct(double price,int quantity,boolean imported){
        super(price, quantity, imported);
    }

    public double getSalesTax(){
        if(super.imported){
            double salesTax = super.salesTaxCalculate(Tax.SALES_TAX+Tax.IMPORT_DUTY);
            return salesTax;
        }
        else{
            return super.salesTaxCalculate(Tax.SALES_TAX);
        }
    }

    public double finalProductCost(){
        double pricevalue = super.priceCalculate();
        return super.roundTo(pricevalue + this.getSalesTax());
    }
    
}
