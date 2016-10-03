
import java.math.BigDecimal;

public class Book {
	
	private String title;
	private String author;
	private BigDecimal price;
	// Constructors
	public Book(){
	}
	
	
	public Book(String bookName, String authorName, BigDecimal cost){
		title = bookName;
		author = authorName;
		price = cost;
	}
	
	public void detailBook(String bookName, String authorName, BigDecimal cost){
		title = bookName;
		author = authorName;
		price = cost;
	}
	
	// Setters
	public void setTitle(String bookName){
		title = bookName;
	}
	
	public void setAuthor(String authorName){
		author = authorName;
	}
	
	public void setPrice(BigDecimal cost){
		price = cost;
	}
	
	// Getters
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public BigDecimal getPrice(){
		return price;
	}

}