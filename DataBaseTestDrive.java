import java.util.ArrayList;

public class DataBaseTestDrive {

	public static void main(String[] args){

		ArrayList<StoreInventory> storeInventoryList = new ArrayList<StoreInventory>();	

		DataBase data = new DataBase();
		data.openFile();
		data.getInventoryFromFile(storeInventoryList);
		data.closeFile();
		// Test to see if the given titles corresponds to the text file
		for(int i=0;i<storeInventoryList.size();i++){
			String textTitle = storeInventoryList.get(i).getBook().getTitle();
			System.out.println(textTitle);
		}
	}

}
