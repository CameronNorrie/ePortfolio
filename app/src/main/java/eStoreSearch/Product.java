package eStoreSearch;

public class Product {
    private int productID;
    private String description;
    private double price;
    private int year;

    public boolean setProductID(String productInput){
        if (productInput.length() < 6 || productInput.length() > 6) {
            System.out.println( "Invalid input for the productID. Input must be 6 digits in legnth.");
            return false;
        } else {

            if(Integer.parseInt(productInput) < 0 || Integer.parseInt(productInput) > 999999){
                System.out.println( "Invalid input for the productID. Input must be 6 digits in legnth.");
                return false;
            } else {
                //the ID given is valid
                productID = productInput;
                return true;
            }
        }
    }

    public int getProductID(){
        return productID;
    }

    public boolean setDescription(String descriptionInput){
        if (descriptionInput.equals("")) {
            System.out.println( "Invalid input, the description cannot be empty." );
            return false;
        } else {
            description = descriptionInput;
            return true;
        }
    }

    public String getDescription(){
        return description;
    }

    public boolean setYear(String yearInput) {
        if (yearInput.length() < 4 || yearInput.length() > 4) {
            System.out.println( "Invalid input, the year must be a legnth of 4 digits." );
            return false;
        } else {

            if (Integer.parseInt(yearInput) < 1000 || Integer.parseInt(yearInput) > 9999) {
                System.out.println( "Invalid input, the year must be be between 1000 and 9999." );
                return false;
            } else {
                year = Integer.parseInt(yearInput);
                return true;
            }
        }
    }

    public int getYear(){
        return year;
    }

    public boolean setPrice (double priceInput){
        if (priceInput <= 0) {
            System.out.println( "Invalid input, the price must be $0 or greater." );
            return false;
        } else {
            price = priceInput;
            return true;
        }
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return (
            "type = \"books\"\n"
            +"product ID = \""+super.getProductID()+"\"\n"
            +"description = \""+super.getDescription()+"\"\n"
            +"year = \""+super.getYear()+"\"\n"
            +"price = \""+super.getPrice()+"\"\n"
        );
    }

    public boolean equals (Object equals){
        Electronics electronics = (Electronics) equals;
        
        return (
            electronics.getDescription() == this.getDescription()
            && electronics.getYear() == this.getYear()
            && electronics.getPrice() == this.getPrice()
        );
    }

}
