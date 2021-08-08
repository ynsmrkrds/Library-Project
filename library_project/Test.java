// This class is a class that includes testing methods

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Test {
    // includes 10% of students to test group
    public static void testCaseBasic(ArrayList<Book> books, Semaphore librarians, ArrayList<Student> students) {
        for(int i = 0; i < (students.size() * 10 / 100); i++) {
            new Thread(new Library(books, librarians, students.get(i))).start();
        }
    }

    // includes 50% of students to the test group
    public static void testCaseMiddle(ArrayList<Book> books, Semaphore librarians, ArrayList<Student> students) {
        for(int i = 0; i < (students.size() * 50 / 100); i++) {
            new Thread(new Library(books, librarians, students.get(i))).start();
        }
    }

    // includes 100% of students to the test group
    public static void testCaseFull(ArrayList<Book> books, Semaphore librarians, ArrayList<Student> students) {
        for (Student student : students) {
            new Thread(new Library(books, librarians, student)).start();
        }
    }
}
