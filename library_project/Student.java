// This class is a model class

import java.util.ArrayList;

public class Student {
    private String schoolNumber; // identity of student
    private ArrayList<String> readingList; // reading list of student

    // constructs the "Student" class
    public Student(String schoolNumber, ArrayList<String> allBooks){
        this.schoolNumber = schoolNumber;
        this.readingList = allBooks;
    }

    // returns school number of student
    public String getSchoolNumber() {
        return this.schoolNumber;
    }

    // returns reading list of student
    public ArrayList<String> getReadingList(){
        return this.readingList;
    }

    // deletes the book it takes as a parameter from reading list of student
    public void deleteBookFromReadingList(String book){
        this.readingList.remove(book);
    }

    // randomly selects the needed book from the reading list and returns it
    public String getNeededBook() {
        return this.readingList.get((int)(Math.random() * this.readingList.size()));
    }
}