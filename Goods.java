import java.util.ArrayList;

public class Goods {
    public static ArrayList<String> food = new ArrayList<String>();
    public static ArrayList<String> medicalProducts = new ArrayList<String>();
    public static ArrayList<String> book = new ArrayList<String>();
    public double price;
    public int quantity;
    public String[] item;
    public double taxPrice;

    static{
        food.add("chocolate");
        food.add("chocolates");
        medicalProducts.add("pills");
        book.add("book");
        book.add("books");
    }
    public Goods(){}
    public Goods(int quantity,double price,String[] item){
        this.quantity = quantity;
        this.price = price;
        this.item = item;
    }

    // method to round the deciamal value close to 0.50
    // public double roundTo(double value){
    //            return Math.ceil(value / 0.05) * 0.05;
    //        }
        public double roundTo(double value) {
            double temp = value * 100;
            if (temp == (int) temp) {
                // System.out.println(temp+" "+"first if");
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



    //    public double roundTo(double value){
    //        return Math.ceil(value / 0.05) * 0.05;
    //    }
    // public double roundTo(double value) {
    //     double temp = value * 100;
    //     if (temp == (int) temp) {
    //         // System.out.println(temp+" "+"first if");
    //         return value;
    //     } else {
    //         String numberInString = String.valueOf(temp);
    //         char numberAfterDecimal = numberInString.charAt(numberInString.indexOf(".") + 1);
    //          //System.out.println(numberInString);
    //          //System.out.println(numberAfterDecimal);
    //         if (Character.getNumericValue(numberAfterDecimal) <= 5) {
    //              //System.out.println("Second if");
    //             String num = numberInString.substring(0, numberInString.indexOf("."));
    //              //System.out.println(num);
    //             num = num.substring(0, num.length() - 1) + "5";
    //              //System.out.println(num+" updated");
    //             return Double.parseDouble(num) / 100;
    //         } else {
    //             return Math.round(Double.parseDouble(numberInString)) / 100.0;
    //         }
    //     }

    // }
    public double priceCalculate(){  //(int quantity, double price){
        //System.out.println(quantity);
        //System.out.println(price);
        return quantity * price;
    }

    private boolean itemContainsinCategory(String[] item,ArrayList<String> category){
        for(int i=0;i<item.length;i++){
            if(category.contains(item[i]))
            return true;
        }
        return false;
    }
    
    // method to find category to avoid sales tax
    public boolean isSpecialCategory(){//(String[] item){
        if (itemContainsinCategory(item, book) || itemContainsinCategory(item, food) || itemContainsinCategory(item, medicalProducts)){
            return true;
        }
        else
            return false;
    }

    public boolean isImported(){//(String[] item){
        for (int i=0;i<item.length;i++){
            if(item[i].equals("imported")){
                return true;
            }
        }
        return false;
    }

    public double finalProductCost(){
        Tax sTax = new Tax();
        //System.out.println("In goods");
        double totalcost = priceCalculate();
        //System.out.println(totalcost);
        taxPrice = sTax.taxCalculate(isSpecialCategory(),isImported(),totalcost);
        //System.out.println(taxPrice);
        return roundTo(totalcost+taxPrice); //deal with .50
    }

    //  public static void main(String args[]){
    //      String[] s = {"imported","chocolate","at"};
    //       Goods g1 = new Goods(1,10.00,s);
    //     // System.out.println(g1.priceCalculate());
    //     // System.out.println(g1.isImported());
    //     // System.out.println(g1.isSpecialCategory());
    //     // System.out.println(g1.finalProductCost());
    //      System.out.println(g1.roundTo(16.489));
    //  }
}
