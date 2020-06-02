package package1;

public class Book {
	
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;
	int dayCheckedOut;
	
	public Book(String title, int pageCount, int ISBN, boolean isCheckedOut, int dayCheckedOut) {
		this.title = title;
		this.pageCount = pageCount;
		this.ISBN = ISBN;
		this.isCheckedOut = isCheckedOut;
		this.dayCheckedOut = dayCheckedOut;
	}
	

	public String getTitle() {
		return this.title;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public int getISBN() {
		return this.ISBN;
	}

	public boolean isCheckedOut() {
		return this.isCheckedOut;
	}

	public int getDayCheckedOut() {
		return this.dayCheckedOut;
	}

	
	private void setTitle(String name) {
		this.title = name;
	}
	
	private void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	private void setISBN(int iSBN) {
		this.ISBN = iSBN;
	}

	private void setCheckedOut(boolean isCheckedOut, int dayCheckedOut) {
		this.isCheckedOut = isCheckedOut;
		setDayCheckedOut(dayCheckedOut);
	}

	private void setDayCheckedOut(int dayCheckedOut) {
		this.dayCheckedOut = dayCheckedOut;
	}
	

}
