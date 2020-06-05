package package1;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
	
	// Attributes of the class
    Map<String,Book> bookCollection = new HashMap<String,Book>();
    //Now method of LocalDate will return today's date
    LocalDate currentDay = LocalDate.now();
    int lengthOfCheckoutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;


    //constructors
    public LibraryCatalogue(Map<String,Book> collection) {
        this.bookCollection = collection;
        //For all the other attributes, we will take default values.
    }   

    public LibraryCatalogue(Map<String,Book> collection, int lengthOfCheckoutPeriod, 
            double initialLateFee, double feePerLateDay) {
        this.bookCollection = collection;
        this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }
    

    // Getters
    public LocalDate getCurrentDay() {
        return currentDay;
    }
    
    public Map<String,Book> getBookCollection() {
        return this.bookCollection;
    }
    

    public Book getBook(String bookTitle) {
        return getBookCollection().get(bookTitle);
    }

    public int getLengthOfCheckoutPeriod() {
        return this.lengthOfCheckoutPeriod;
    }

    public double getInitialLateFee() {
        return this.initialLateFee;
    }

    public double getFeePerLateDay() {
        return this.feePerLateDay;
    }

 
    public void checkOutBook(String title) {
    	// taking the book from library for a particular period so the book will be unavailable for others
        Book book = getBook(title);

        if (book.getIsCheckedOut()) {
            sorryBookAlreadyCheckedOut(book);
        } 
        
        else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ". It is due on day "+ 
                   (getCurrentDay().plusDays(getLengthOfCheckoutPeriod())+"." ));
        }
    }
    

    public void returnBook(String title) {
    	// returning book to library so it is no longer checked out
       Book book = getBook(title);
       Duration diff = Duration.between(currentDay.atStartOfDay(), 
    		   (book.getDayCheckedOut().plusDays(getLengthOfCheckoutPeriod()).atStartOfDay()));
       int daysLeft = (int) diff.toDays();

       if (daysLeft < 0) {
           System.out.println("You owe the library €" + (getInitialLateFee() + daysLeft * getFeePerLateDay()) + 
                   " because your book is "+ daysLeft+ " days overdue.");
       } else {
           System.out.println(title+" Book Returned. Thank you!");
       }
       book.setIsCheckedOut(false, null);
    }
    

    public void sorryBookAlreadyCheckedOut(Book book) {
    	//Print a sweet message if the book is checked out
        System.out.println("Sorry, " + book.getTitle() + " is already checked out. "
                + "It should be back on day " + (book.getDayCheckedOut().plusDays(getLengthOfCheckoutPeriod())) 
                + ".");
    }
    
    public void seeAllBooks() {
    	//this will print all the books
    	System.out.println(bookCollection.keySet());
    }
    

    public static void main(String[] args) { 	
        Map<String, Book> bookCollection = new HashMap<String,Book>();
        Book harry = new Book("Harry Potter", 827132, 9999999);
        bookCollection.put("Harry Potter", harry);
        LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
        lib.checkOutBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
        lib.seeAllBooks();;
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
        
    }
}
