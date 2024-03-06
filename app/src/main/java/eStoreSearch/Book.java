package eStoreSearch;
import java.util.Scanner;

public class Book {
    private String publisher;
    private String authors;

    public void setPublisher (String publisherInput){
        publisher = publisherInput;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setAuthors (String authorsInput){
        authors = authorsInput;
    }

    public String getAuthors(){
        return authors;
    }

    @Override
    public String toString(){
        return (
            "type = \"books\"\n"
            +"product ID = \""+super.getProductID()+"\"\n"
            +"description = \""+super.getDescription()+"\"\n"
            +"price = \""+super.getPrice()+"\"\n"
            +"year = \""+super.getYear()+"\"\n"
            +"authors = \""+getAuthors()+"\"\n"
            +"publisher = \""+getPublisher()+"\""
        );
    }

    @Override
    public boolean equals (Object equals){
        Book books = (Book) equals;

        return (
            books.getDescription() == this.getDescription()
            && books.getPrice() == this.getPrice()
            && books.getYear() == this.getYear()
            && books.getPublisher() == this.getPublisher()
            && books.getAuthors() == this.getAuthors()
        );
    }
}