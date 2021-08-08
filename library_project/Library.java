// This class is a class that represents a library

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Library implements Runnable{
    private ArrayList<Book> books; // books in the library
    private Semaphore librarians; // librarians working in the library
    private Student student; // student that will talk with librarian

    // constructs the "Library" class
    public Library(ArrayList<Book> books, Semaphore librarians, Student student){
        this.books = books;
        this.librarians = librarians;
        this.student = student;
    }

    @Override
    public void run() {
        talkWithStudent();
        
        lendTheBook(searchTheBook(student.getNeededBook()));
    }

    /* lends the book to the student if the book is available, otherwise 
       student comes again to borrow the book from the library */
    private void lendTheBook(Book book) {
        // if the book is not found, give a feedback (it is not so important now !!!)
        if(book == null) {
            giveFeedback("I think, I spelled the book name wrong.");
        } else {
            // if the book is in someone else
            if(book.isBorrowed()) {
                finishTalking(); // conversation ends
                giveFeedback("The book '" + book.getName() + "' I wanted is now in someone else. I will come again.");
                competeToTalk(); // student tries to talk again to get the book
            } else { // if the book is available
                book.setState(true); // student borrows the book from the library
                student.deleteBookFromReadingList(book.getName()); // student deletes the needed book from his/her reading list
                giveFeedback("I borrowed the book '" + book.getName() + "' and deleted it from my reading list.");
                finishTalking(); // conversation ends
                
                waitLittle(); // student is reading the book
                getTheBookBack(book);
            }
        }
    }

    // gets back the book from the student
    private void getTheBookBack(Book book) {
        book.setState(false); // the readed book is returned to the library
        giveFeedback("I returned the book '" + book.getName() + "' I borrowed from the library to the library.");

        if(student.getReadingList().size() == 0) {
            giveFeedback("\u001B[31m" + "I've read all the books on my book list!!!" + "\u001B[0m");
        } else {
            competeToTalk();
        }
    }

    // the book taken as a parameter is searched and returned
    private Book searchTheBook(String neededBook) {
        for(Book book : books) {
            if(neededBook == book.getName()) {
                // librarian found the book in the library software system
                return book;
            }
        }

        return null; // if book is not found
    }

    // any librarian initiates the conversation with the student who grab a queue
    private void talkWithStudent() {
        try {
            librarians.acquire(); // reserves an available librarian
            giveFeedback("I'm talking with a librarian.");
        } catch (InterruptedException e) {
            giveFeedback("I left without talking with librarian from library.");
            competeToTalk(); // if the student is somehow unable to talk with librarian, he/she tries again to talk with librarians
        }
    }

    // finishs the conversation between the student and the librarian
    private void finishTalking() {
        librarians.release(); // makes the availability of librarian that in the conversation available
        giveFeedback("I'm done talking with the librarian. I'm leaving from the library.");
    }

    // begins student competition with other students to talk with a librarian
    private void competeToTalk() {
        waitLittle(); // waits a little first
        new Thread(new Library(this.books, this.librarians, this.student)).start(); // begins to compete to talk
    }

    // makes a student who takes his/her chance put on hold for a while
    private void waitLittle(){
        try {
            Thread.sleep((int)(Math.random() * 1000) + 1); // waits between 0 - 1000 ms
        } catch (InterruptedException e) {
            giveFeedback("Sorry, I couldn't wait :D.");
        }
    }

    // prints the message received as a parameter to the screen
    // written to let the developer know which student is in what condition
    private void giveFeedback(String message) {
        System.out.format("Student %s : %s\n", student.getSchoolNumber(), message);
    }
}
