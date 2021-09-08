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
        public double roundTo(double value) {
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

    public double priceCalculate(){ 
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
    public boolean isSpecialCategory(){
        if (itemContainsinCategory(item, book) || itemContainsinCategory(item, food) || itemContainsinCategory(item, medicalProducts)){
            return true;
        }
        else
            return false;
    }

    public boolean isImported(){
        for (int i=0;i<item.length;i++){
            if(item[i].equals("imported")){
                return true;
            }
        }
        return false;
    }

    public double finalProductCost(){
        Tax sTax = new Tax();
        double totalcost = priceCalculate();
        taxPrice = sTax.taxCalculate(isSpecialCategory(),isImported(),totalcost);
        return roundTo(totalcost+taxPrice);
    }

}
