import java.math.BigDecimal;
import java.util.ArrayList;

public class StoreKeeperTestDrive {

	public static void main(String[] args){
		StoreKeeper StoreKeeperTest = new StoreKeeper();
		
		// Test the initialization of the store inventory
		for(int i=0;i<StoreKeeperTest.getStoreInventory().size();i++){
			String textTitle = StoreKeeperTest.getStoreInventory().get(i).getBook().getTitle();
			System.out.println(textTitle);
		}
		System.out.println("---------------------");
		
		
		// Test the search method
		Book[] bookArray =  StoreKeeperTest.list("Generic");
		for(int i=0;i<bookArray.length;i++){
			String textTitle = bookArray[i].getTitle();
			System.out.println(textTitle);
		}
		System.out.println("---------------------");
		
		// Check if you can add a new book and that only the quantity change 
		// if you try add a old one.
		
		Book newBook = new Book("Travesty","Dante",new BigDecimal("5.0"));
		BigDecimal oldPrice = new BigDecimal("999.00");
		Book oldBook = new Book("Random Sales","Cunning Bastard", oldPrice);
		
		StoreKeeperTest.add(newBook, 0);
		StoreKeeperTest.add(oldBook, 5);
		ArrayList<StoreInventory> storeInventoryList = StoreKeeperTest.getStoreInventory();
		for(int i=0;i<storeInventoryList.size();i++){
			String textTitle = storeInventoryList.get(i).getBook().getTitle();
			System.out.println(textTitle);
			if (textTitle.equalsIgnoreCase("Random Sales") && 
					(storeInventoryList.get(i).getBook().getPrice().compareTo(oldPrice))==0){
				int temp = storeInventoryList.get(i).getQuantity();
				System.out.println(temp);
			}
		}
		System.out.println("---------------------");
		
		// Test checkIfBooksExists method
		int exists = StoreKeeperTest.checkIfBooksExists(oldBook);
		System.out.println(exists);
		System.out.println("---------------------");
		
		// Test buy method
		int[] stockNew = StoreKeeperTest.buy(newBook);
		System.out.println(stockNew[0]);
		int[] stockOld = StoreKeeperTest.buy(oldBook);
		System.out.println(stockOld[0]);
		Book fakeBook = new Book("Druid","Cunning Bastard", oldPrice);
		int[] stockFake = StoreKeeperTest.buy(fakeBook);
		System.out.println(stockFake[0]);
		int[] stockArray = StoreKeeperTest.buy(bookArray);
		System.out.println(stockArray[0]);
	}
}



