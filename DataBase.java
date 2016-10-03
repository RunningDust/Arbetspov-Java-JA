import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
// I use URL and IOException since I need them to interact with the text file
// Here I also use the scanner to help with processing the text file

public class DataBase {
private Scanner sFeed;
	
	public void openFile(){
	try {
		   URL url = new URL("http://www.contribe.se/bookstoredata/bookstoredata.txt");
		   sFeed = new Scanner(url.openStream(),"UTF-8");
		   // read from your scanner
		}
		catch(IOException ex) {
		   System.out.println("Could not read url");
		}
	}
	
	public void getInventoryFromFile(ArrayList<StoreInventory> storeInventoryList){
		sFeed.useDelimiter(";|\n");
		String[] temp = new String[4];
		int counter = 0;
		while(sFeed.hasNext()){
			String a = sFeed.next();
			temp[counter] = a;
			if (counter == 3){
				String bookName = temp[0];
				String authorName = temp[1];
				temp[2] = temp[2].replaceAll(",","");
				BigDecimal cost = new BigDecimal(temp[2]);
				int quantity = Integer.parseInt(temp[3]);
				storeInventoryList.add(new StoreInventory(bookName, authorName, cost, quantity));
				counter = 0;
			} else{
				counter++;
			}
		}
	}
	
	public void closeFile(){
		sFeed.close();
	}
}
