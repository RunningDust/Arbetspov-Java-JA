import java.util.ArrayList;

public class StoreKeeper implements BookList {
	// Inventory list
	private ArrayList<StoreInventory> storeInventoryList = new ArrayList<StoreInventory>();
	
	// Get data from text file online using the DataBase class
	public StoreKeeper(){
		DataBase data = new DataBase();
		data.openFile();
		data.getInventoryFromFile(storeInventoryList);
		data.closeFile();
	}
	// 
	public Book[] list(String searchString) {
		ArrayList<Book> listClone = new ArrayList<Book>();
		// Make the search case insensitive
		String testString = "(?i)" + searchString + ".*";
		// Search the inventory list for the specific search string
		for(int i=0;i<storeInventoryList.size();i++){
			String textTitle = storeInventoryList.get(i).getBook().getTitle();
			String textAuthor = storeInventoryList.get(i).getBook().getAuthor();
			if(textTitle.matches(testString) || textAuthor.matches(testString)){
				listClone.add(storeInventoryList.get(i).getBook());
			}
		}
		// convert the dynamic arraylist to an array as per request
		Book[] BookArray = new Book[listClone.size()];
		BookArray = listClone.toArray(BookArray);
		return BookArray;
	}

	public boolean add(Book book, int quantity) {
		// check if book already exists, in which case we only add to the quantity
		int index = checkIfBooksExists(book);
		if(index >= 0){
			int currentQuantity = storeInventoryList.get(index).getQuantity();
			currentQuantity = currentQuantity + quantity;
			storeInventoryList.get(index).setQuantity(currentQuantity);
			return true;
		} else{

			storeInventoryList.add(new StoreInventory(book.getTitle(),
					book.getAuthor(),book.getPrice(), quantity));

			return false;
		}
	}

	public int[] buy(Book... books) {
		// check the inventory quantity for all books in the array books 
		int numberOfIterations = books.length;
		int[] stockStatus = new int[numberOfIterations];
		for(int i = 0; i < numberOfIterations; i++){
			int index = checkIfBooksExists(books[i]);
			if (index >= 0){
				int stockQuantity = storeInventoryList.get(index).getQuantity();
				if (stockQuantity > 0){
					stockStatus[i] = 0; 
				}else{
					stockStatus[i] = 1; 
				}
			}else{
				stockStatus[i] = 2; 
			}
		}
		return stockStatus;
	}

	
	public ArrayList<StoreInventory> getStoreInventory(){
		return storeInventoryList;
	}

	public int checkIfBooksExists(Book givenBook){
		// Check if book exists, returning the index of the 
		// book in the storeInventoryList if it does, -1 otherwise.
		int exists = -1;
		boolean bookExists = false;
		// I do this loop since I want to compare references latter and this gives me 
		// the reference of the book should it already exist in the list. I want to avoid 
		// problems if someone creates a new book object that is equal to an existing one,
		// as that should also count towards the existing book.
		Book[] bookArray = list(givenBook.getTitle());
		int index = 0;
		for(int i=0;i<bookArray.length;i++){
			if (bookArray[i].getAuthor().equalsIgnoreCase(givenBook.getAuthor()) && 
					(bookArray[i].getPrice().compareTo(givenBook.getPrice()))==0){
				bookExists = true;
				index = i;
				break;
			}
		}
		if(bookExists){
			Book currentBook = bookArray[index];
			for(int i=0;i<storeInventoryList.size();i++){
				// Here i simple check if the handlers point to the same object.
				if (currentBook == storeInventoryList.get(i).getBook()){
					exists = i;
				}
			}
		}
		return exists;
	}
}