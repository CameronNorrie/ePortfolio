package eStoreSearch;
import java.util.Scanner;
import java.util.ArrayList;

public class EStoreSearch {
    private Scanner scanner = new Scanner(System.In);
    

    public void add(ArrayList<Product> product){
        Book book = new Book();
        Electronics electronics = new Electronics();

        while (!(product.equalsIgnoreCase("book") && product.equalsIgnoreCase("electronics"))) {
            System.out.println("Please enter the product type, book or electronics: ");
            product = scanner.nextLine();
        }

    }

    public void openFile(String file, ArrayList<Product> product){

    }
}
