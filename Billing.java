import java.text.DecimalFormat;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Billing {
    private static final List<String> food = Collections.unmodifiableList(Arrays.asList("chocolate", "chocolates"));
    private static final List<String> books = Collections.unmodifiableList(Arrays.asList("book", "books"));
    private static final List<String> medicalProducts = Collections.unmodifiableList(Arrays.asList("pills"));

    public boolean isImported(String[] item) {
        for (int i = 0; i < item.length; i++) {
            if (item[i].equals("imported")) {
                return true;
            }
        }
        return false;
    }

    private boolean itemContainsinCategory(String[] item, List<String> category) {
        for (int i = 0; i < item.length; i++) {
            if (category.contains(item[i]))
                return true;
        }
        return false;
    }

    // method to find category to avoid sales tax
    public boolean isSpecialCategory(String[] item) {
        if (itemContainsinCategory(item, books) || itemContainsinCategory(item, food)
                || itemContainsinCategory(item, medicalProducts)) {
            return true;
        } else
            return false;
    }

    public void printTotalQuantityPrice(String quantity, String[] item,Double finalPrice) {
        String billingLine = quantity;
        for (int elementInItem = 0; elementInItem < item.length; elementInItem++) {
            billingLine = billingLine + " " + item[elementInItem];
        }
        System.out.println(billingLine + ": " + String.valueOf(new DecimalFormat("#,##0.00").format(finalPrice)));
    }

    public void printSalesTaxesAndTotal(double total,double salestax) {
        System.out.println("Sales taxes: "
                + String.valueOf(new DecimalFormat("#,##0.00").format(Math.ceil(salestax / 0.05) * 0.05)));
        System.out.println("Total: " + String.valueOf(new DecimalFormat("#,##0.00").format(total)));
    }

    
}
