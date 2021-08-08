# Operating Systems Term Project “Books In The Library”

## Purpose of the Project

    Learning “thread” working logic

## Scenario of the Project

    In order for the students at the school to do their term projects, they should borrow the books to be read from the library and read them. The students arrive at the library in random order, and they compete to talk one of the librarians. When a student catches one of the librarians, he/she asks the book he/she needs. The librarian checks the status of the book and, if the status of the book is available, gives the book to the student for a random time. If the book is in another person, the student leaves from the library and comes back to the library. This process continues until the student has read all the books in the reading list.

## Programming Language

    Java – openjdk v11.0.11

## Structures Used in the Solution

    Java Threads, Semaphore

## Classes

1. **Main.java:** The “Main” class is main class of the application. This class includes four variables and a “main” method.

    VARIABLES

    - *“STUDENT_NUMBER"* is a constant integer value and represents total student number in the school. (default value is “40”.)

    - *“LIBRARIANS_NUMBER”* is a constant integer value and represents total librarian number that works in the library. (default value is “3”.)

    - *“BOOK_NAMES”* is a constant string array and includes book names in the library. (there are “6” book by default.)

    - *“LIBRARIANS”* is a constant semaphore. I preferred the semaphore structure as a librarian will be talking to one student at a time.

    METHODS

    - *“main”* is a public static method. Students in the school and books in the library are created in this method. Also, test of the application is done in this method.

2. **Test.java:** The “Test” class is a class that includes test methods. You can use this class to test this application with different student groups.

    METHODS

    - *“testCaseBacic”* is a public static method. Runs this application for 10% of students in the school.

    - *“testCaseMiddle”* is a public static method. Runs this application for 50% of students in the school.

    - *“testCaseFull”* is a public static method. Runs this application for 100% of students in the school.

3. **Book.java:** The “Book” class is a model class for books in the library. This class includes two variables and three methods.

    VARIABLES

    - *“name”* is a string variable and represents name of the book.

    - *“state”* is a boolean variable and represents status of the book.

    METHODS

    - *“getName”* is a public method that returns name of the book.

    - *“isBorrowed”* is a public method that returns status of the book. This method returns true if the book is in someone else, otherwise false.

    - *“setState”* is a public method that sets status of the book.

4. **Student.java:** The “Student” class is a model class for students in the school. This class includes two variables and four methods.

    VARIABLES

    - *“schoolNumber”* is a string variable and represents school number of the student.

    - *“readingList”* is a string array list and includes book names that student must read.

    METHODS

    - *“getSchoolNumber”* is a public method that returns school number of the student.

    - *“getReadingList”* is a public method that returns reading list of the student.

    - *“deleteBookFromReadingList”* is a public method that allows deleting books from the student’s reading list.

    - *“getNeededBook”* is a public method. This method randomly selects any book in the student's reading list and returns the selected book.

5. **Library.java:** The “Library” class is a class that represents a library. This class implements Runnable class and so, includes a “run()” method. Also, this class totally includes three variables and nine methods.

    VARIABLES

    - *“books”* is a Book array and includes books in the library.

    - *“librarians”* is a semaphore and represents librarians that works in the library.

    - *“student”* is a Student and represent a student that coming to library for borrow a book from the library.

    METHODS

    - *“run”* is a overrided method interited Runnable class. When thread is start, this method is triggered.

    - *“lendTheBook”* is a private method. It is used to lend any book in the reading list of the student that speaking with the librarian to the student. If book that the student wants is in someone else, the student ends the talking with librarian and leaves from the library. Then the student competes again to talk with any librarian. If the book is available, the librarian lends the book to the student for a random time period. The student deletes the book from his/her reading list and ends the conversation. After the time period, the book is returned.

    - *“getTheBookBack”* is a private method. It is used to get book that borrowed by the student back. After the book is returned, if there is a book in the reading list of the student, the student comes again to the library and competes again to borrow the book from the library. Otherwise, the student gives a message that he/she has read all the books.

    - *“searchTheBook”* is a private method. It is used to access any of the books in the library. The needed book is searched in all books in the library and returned it if found.

    - *“talkWithStudent”* is a private method. This method initiates a conversation between any librarian and any student who wants to borrow a book from the library.

    - *“finishTalking”* is a private method that ends the conversation between the librarian and the student.

    - *“competeToTalk”* is a private method that begins student competition with other students to talk with a librarian.

    - *“waitLittle”* is a private method that makes a student who takes his/her chance put on hold for a while.

    - *“giveFeedback”* is a private method that written to let the developer know which student is in what condition. This method prints the message received as a parameter to the screen.

