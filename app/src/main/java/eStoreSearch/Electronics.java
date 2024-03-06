package eStoreSearch;
import java.util.Scanner;

public class Electronics {
    private String maker;

    public void setMaker(String makerInput){
        maker = makerInput;
    }

    public String getMaker(){
        return maker;
    }

    @Override
    public String toString(){
        return (
            "type = \"electronics\"\n"
            +"product ID = \""+super.getProductID()+"\"\n"
            +"description = \""+super.getDescription()+"\"\n"
            +"price = \""+super.getPrice()+"\"\n"
            +"year = \""+super.getYear()+"\"\n"
        );
    }

    @Override
    public boolean equals (Object equals){
        Electronics electronics = (Electronics) equals;

        return (
            electronics.getDescription() == this.getDescription()
            && electronics.getPrice() == this.getPrice()
            && electronics.getYear() == this.getYear()
            && electronics.getMaker() ==getMaker()
        );
    }
}