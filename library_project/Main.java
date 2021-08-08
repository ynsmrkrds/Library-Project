// This class is main class of the application

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Main {
    static final int STUDENT_NUMBER = 40; // total student number in the school
    static final int LIBRARIANS_NUMBER = 3; // total librarian number that works in the library
    static final String[] BOOK_NAMES = {"Book_1", "Book_2", "Book_3", "Book_4", "Book_5", "Book_6"}; // book names in the library
    static final Semaphore LIBRARIANS = new Semaphore(LIBRARIANS_NUMBER); // librarians that works in the library

    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>(); // books in the library
        ArrayList<Student> students = new ArrayList<Student>(); // students in the school

        // creates books
        for(int i = 0; i < BOOK_NAMES.length; i++) {
            books.add(new Book(BOOK_NAMES[i], false));
        }

        // creates students
        for(int i = 1; i <= STUDENT_NUMBER; i++) {
            students.add(new Student(Integer.toString(i), new ArrayList<String>(Arrays.asList(BOOK_NAMES))));
        }

        /* TESTING
           select one of the test lines and comment the others 
        */

        // Test.testCaseBasic(books, LIBRARIANS, students);
        // Test.testCaseMiddle(books, LIBRARIANS, students);
        Test.testCaseFull(books, LIBRARIANS, students);
    }
}
