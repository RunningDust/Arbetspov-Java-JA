import java.math.BigDecimal;

public class StoreInventory {
	private Book book;
	private int quantity;
	// Constructor
	public StoreInventory(String bookName, String name, BigDecimal cost, int numberInStore){
		book = new Book (bookName, name, cost);
		quantity = numberInStore;
	}
	// Getters
	public Book getBook(){
		return book;
	}
	public int getQuantity(){
		return quantity;
	}
	//Setters
	public void giveBook(Book newBook){
		book = newBook;
	}
	public void setQuantity(int newNumber){
		quantity = newNumber;
	}
	
}
