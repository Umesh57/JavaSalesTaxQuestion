import java.text.DecimalFormat;

public class Billing extends Goods{
    public static double total;
    public static double salesTax;

    public Billing(){

    }
    public Billing(int quantity,double price,String[] item){
        super(quantity, price, item);
    }

    public void printTotalQuantityPrice(){
        String billingLine = Integer.toString(super.quantity);
        for (int elementInItem=0;elementInItem<super.item.length;elementInItem++){
            billingLine = billingLine + " " +super.item[elementInItem];
        }
        double temp = super.finalProductCost();
        System.out.println(billingLine+": "+String.valueOf(new DecimalFormat("#,##0.00").format(temp)));
        total += temp;
        salesTax+=super.taxPrice; 
    }
    
    public void printSalesTaxesAndTotal(){
        System.out.println("Sales taxes: "+String.valueOf(new DecimalFormat("#,##0.00").format(Math.ceil(salesTax / 0.05) * 0.05)));
        System.out.println("Total: "+String.valueOf(new DecimalFormat("#,##0.00").format(total)));
    }

}
