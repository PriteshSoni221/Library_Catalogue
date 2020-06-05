package package1;

import java.time.LocalDate;


public class Book {
	
	//attributes
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;
	LocalDate dayCheckedOut;
	
	//constructor
	public Book(String title, int pageCount, int ISBN) {
		this.title = title;
		this.pageCount = pageCount;
		this.ISBN = ISBN;
		this.isCheckedOut = false;
	}
	
	// Getters
	public String getTitle() {
		return this.title;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public int getISBN() {
		return this.ISBN;
	}

	public boolean getIsCheckedOut() {
		return this.isCheckedOut;
	}

	public LocalDate getDayCheckedOut() {
		return this.dayCheckedOut;
	}

	
	//Setters
	public void setIsCheckedOut(boolean isCheckedOut, LocalDate dayCheckedOut) {
		this.isCheckedOut = isCheckedOut;
		setDayCheckedOut(dayCheckedOut);
	}

	public void setDayCheckedOut(LocalDate dayCheckedOut) {
		this.dayCheckedOut = dayCheckedOut;
	}
	
}
