import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingBasket {
    public static void main(String args[]) throws FileNotFoundException {
        if (0 < args.length) {
            try  {  
                FileInputStream fis=new FileInputStream(args[0]);       
                Scanner sc=new Scanner(fis);
                while(sc.hasNextLine()){  
                    String line = sc.nextLine();
                    String[] lines = line.split(" ");
                    String[] item = Arrays.copyOfRange(lines,1,lines.length-2);
                    Billing bill = new Billing(Integer.parseInt(lines[0]), Double.parseDouble(lines[lines.length-1]),item);
                    bill.printTotalQuantityPrice();
                }
                Billing bill = new Billing();
                bill.printSalesTaxesAndTotal();
                sc.close();
            }
            catch(IOException e)   { 
                e.printStackTrace();
            }  
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(0);
        }
    }
}
