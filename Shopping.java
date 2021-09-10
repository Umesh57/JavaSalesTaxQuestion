import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Shopping {
    public static void main(String args[]) throws FileNotFoundException {
        if (0 < args.length) {
            try {
                double totalcost=0,salestax=0;
                FileInputStream fis = new FileInputStream(args[0]);
                Scanner sc = new Scanner(fis);
                Billing bill = new Billing();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] lines = line.split(" ");
                    String[] item = Arrays.copyOfRange(lines, 1, lines.length - 2);
                    if(bill.isSpecialCategory(item)){
                        SpecialProduct product = new SpecialProduct(Double.parseDouble(lines[lines.length - 1]), Integer.parseInt(lines[0]), bill.isImported(item));
                        double temp = product.finalProductCost();
                        bill.printTotalQuantityPrice(lines[0],item,temp);
                        totalcost += temp;
                        salestax += product.getSalesTax();   
                    }
                    else{
                        OrdinaryProduct product = new OrdinaryProduct(Double.parseDouble(lines[lines.length - 1]), Integer.parseInt(lines[0]), bill.isImported(item));
                        double temp = product.finalProductCost();
                        bill.printTotalQuantityPrice(lines[0],item,temp);
                        totalcost += temp;
                        salestax += product.getSalesTax();
                    }
                }
                bill.printSalesTaxesAndTotal(totalcost,salestax);
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(0);
        }
    }   
}
