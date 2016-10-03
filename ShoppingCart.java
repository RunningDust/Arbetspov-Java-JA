import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<Book> Inventory = new ArrayList<Book>();
	private BigDecimal currentCost;
	
	public ShoppingCart(){
		currentCost = new BigDecimal("0.0");
	}
	
	public void setPrice(BigDecimal newPrice){
		currentCost = newPrice;
	}
	
	public ArrayList<Book> getInventory(){
		return Inventory;
	}
	
	public BigDecimal getPrice(){
		return currentCost;
	}
	
	public void addBookToCart(Book book){
		currentCost = currentCost.add(book.getPrice());
		Inventory.add(book);
	}
	
	public void removeBookToCart(Book book){
		currentCost.subtract(book.getPrice());
		Inventory.remove(book);
	}
}
