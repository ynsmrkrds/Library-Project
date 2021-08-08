// This class is a model class

public class Book {
    private String name; // name of book
    private Boolean state; // availability of book

    // constructs the "Book" class
    public Book(String name, Boolean state){
        this.name = name;
        this.state = state;
    }

    // returns name of book
    public String getName(){
        return this.name;
    }

    // returns false if book is available, else true
    public Boolean isBorrowed(){
        return this.state;
    }

    // sets state of book
    // if book is available, state of book is false
    // if book is not available, state of book is true
    public void setState(Boolean state){
        this.state = state;
    }
}