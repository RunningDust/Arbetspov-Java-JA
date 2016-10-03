import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
//I use BigDecimal since it was specified in the assignment
//I use ArrayList to give me dynamic lists (it helps a lot)
//I use Scanner in order to help me with the user inputs



public class StartShopping {


	public static void main(String[] args){
		StoreKeeper shopStoreKeeper = new StoreKeeper();
		ShoppingCart customerShoppingCart = new ShoppingCart();
		Scanner input = new Scanner(System.in);
		boolean remain = Start(input);
		// Main while loop of the program, here all the user decisions are made
		// I used methods to hide most of the ugly code
		while(remain){
			int answer = mainMenu(input);
			if (answer == 1){
				while(true){
					boolean remainLook = lookAtInventory(input, shopStoreKeeper, customerShoppingCart);
					if (remainLook == false){
						break;
					}
				}
			}else if (answer == 2){
				while(true){
					boolean remainAdd = AddBook(input,shopStoreKeeper);
					if (remainAdd == false){
						break;
					}
				}
			}else if (answer == 3){
				while(true){
					boolean remainCart = viewCart(input, customerShoppingCart);
					if (remainCart == false){
						break;
					}
				}

			}else if (answer == 4){
				remain = checkout(input, customerShoppingCart);

			}else{
				System.out.println("Something went horribly wrong, "
						+ "you will be logged out, contact support");
				remain = false;
			}
		}
		System.out.println("Thanks for your visit!");
	}


	// Here things start to become less commented
	public static boolean Start(Scanner input){
		boolean remain = true;
		boolean goodAnswer = false;
		int number = 0;
		String Answer = null;
		System.out.println("Hello, would you like to start shopping? Yes[1], No[2]");
		do {
			if (input.hasNextInt()){
				number = input.nextInt();
				if (number == 1){
					goodAnswer = true;
				} else if (number == 2){
					remain = false;
					goodAnswer = true;
				} else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			}else{
				Answer = input.next();
				if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")){
					goodAnswer = true;
				}else if (Answer.equalsIgnoreCase("no") || Answer.equalsIgnoreCase("n")){
					remain = false;
					goodAnswer = true;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					input.next();
					goodAnswer = false;
				}
			}
		} while (!(goodAnswer));
		return remain;
	}

	public static int mainMenu(Scanner input){
		int option = 0;
		boolean goodAnswer = false;
		int number = 0;
		String Answer = null;
		System.out.println("Would you like to look at our inventory?[1]");
		System.out.println("Add a new book to our inventory? (Yes anyone can do it!)[2]");
		System.out.println("View your shopping cart?[3]");
		System.out.println("Proceed to checkout?[4]");
		do {
			if (input.hasNextInt()){
				number = input.nextInt();
				if (number == 1){
					goodAnswer = true;
					option = 1;
				} else if (number == 2){
					goodAnswer = true;
					option = 2;
				} else if (number == 3){
					goodAnswer = true;
					option = 3;
				}else if (number == 4){
					goodAnswer = true;
					option = 4;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
				}
			}else{
				Answer = input.next();
				if (Answer.equalsIgnoreCase("inventory") || Answer.equalsIgnoreCase("look")){
					goodAnswer = true;
					option = 1;
				}else if (Answer.equalsIgnoreCase("add") || Answer.equalsIgnoreCase("new")){
					goodAnswer = true;
					option = 2;
				}else if (Answer.equalsIgnoreCase("view") || Answer.equalsIgnoreCase("shopping cart")){
					goodAnswer = true;
					option = 3;
				}else if (Answer.equalsIgnoreCase("proceed") || Answer.equalsIgnoreCase("checkout")){
					goodAnswer = true;
					option = 4;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			}
		} while (!(goodAnswer));

		return option;
	}

	public static boolean AddBook(Scanner input, StoreKeeper shopStoreKeeper){
		int option = 0;
		boolean goodAnswer = false;
		boolean remain = true;
		int number = 0;
		String Answer = null;
		System.out.println("Add a new book to our inventory?[1]");
		System.out.println("Go back?[2]");
		do {
			if (input.hasNextInt()){
				number = input.nextInt();
				if (number == 1){
					goodAnswer = true;
					remain = true;
					option = 1;
				} else if (number == 2){
					goodAnswer = true;
					remain = false;
					option = 2;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					remain = false;
					input.next();
				}
			}else{
				Answer = input.next();
				if (Answer.equalsIgnoreCase("add") || Answer.equalsIgnoreCase("new")){
					goodAnswer = true;
					remain = true;
					option = 1;
				}else if (Answer.equalsIgnoreCase("go back") || Answer.equalsIgnoreCase("back")){
					goodAnswer = true;
					remain = false;
					option = 2;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			}
		} while (!(goodAnswer));

		if (option == 1){
			goodAnswer = false;
			String title = null;
			System.out.println("Please give the title of the book.");
			do {
				if (input.hasNext()){
					goodAnswer = true;
					title = input.next();
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			} while (!(goodAnswer));

			goodAnswer = false;
			String author = null;
			System.out.println("Please give the author of the book.");
			do {
				if (input.hasNext()){
					goodAnswer = true;
					author = input.next();
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			} while (!(goodAnswer));

			goodAnswer = false;
			BigDecimal price = new BigDecimal(0.0);
			System.out.println("Please give the price of the book.");
			do {
				if (input.hasNextBigDecimal()){
					goodAnswer = true;
					price = input.nextBigDecimal();
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			} while (!(goodAnswer));

			goodAnswer = false;
			int quantity = 0;
			System.out.println("Please give the number copies of the book you will provide.");
			do {
				if (input.hasNextInt()){
					if (quantity >= 0){
						goodAnswer = true;
						quantity = input.nextInt();
					}else{
						System.out.println("Please give a positive amount!");
						goodAnswer = false;
						input.next();
					}

				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			} while (!(goodAnswer));
			System.out.println("Title = " + title);
			System.out.println("Author = " + author);
			System.out.println("Price = " + price);
			System.out.println("Number of copies = " + quantity);

			System.out.println("Create book?Yes[1], No[2]");
			boolean create = false;
			goodAnswer = false;
			do {
				if (input.hasNextInt()){
					number = input.nextInt();
					if (number == 1){
						create = true;
						goodAnswer = true;
					} else if (number == 2){
						create = false;
						goodAnswer = true;
					} else{
						System.out.println("Could not understand you, please give your answer again.");
						goodAnswer = false;
						input.next();
					}
				}else{
					Answer = input.next();
					if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")){
						create = true;
						goodAnswer = true;
					}else if (Answer.equalsIgnoreCase("no") || Answer.equalsIgnoreCase("n")){
						create = false;
						goodAnswer = true;
					}else{
						System.out.println("Could not understand you, please give your answer again.");
						goodAnswer = false;
						input.next();
					}
				}
			} while (!(goodAnswer));
			if (create){
				shopStoreKeeper.add(new Book(title, author, price), quantity);
				System.out.println("Book added!");
			}else{
				System.out.println("Book not added!");
			}
		}
		return remain;
	}

	public static boolean lookAtInventory(Scanner input, StoreKeeper shopStoreKeeper, ShoppingCart customerShoppingCart){

		int option = 0;
		boolean buy = false;
		boolean goodAnswer = false;
		boolean remain = true;
		int number = 0;
		System.out.println("Do you want to search our inventory?[1]");
		System.out.println("See all of our inventory?[2]");
		System.out.println("Go back?[3]");
		do {
			if (input.hasNextInt()){
				number = input.nextInt();
				if (number == 1){
					goodAnswer = true;
					option = 1;
				} else if (number == 2){
					goodAnswer = true;
					option = 2;
				}else if (number == 3){
					goodAnswer = true;
					remain = false;
					option = 3;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			}else{
				goodAnswer = false;
				System.out.println("Could not understand you, please give your answer again.");
				input.next();
			}
		} while (!(goodAnswer));

		if (option == 1){
			String searchString = null;
			System.out.println("Enter your search word");
			do {
				if (input.hasNext()){
					searchString = input.next();
					goodAnswer = true;
				}else{
					goodAnswer = false;
					System.out.println("Could not understand you, please give your answer again.");
					input.next();
				}
			} while (!(goodAnswer));
			Book[] bookArray = shopStoreKeeper.list(searchString);
			int counter = 1;
			if (bookArray.length == 0){
				System.out.println("Sorry, could not find a match");
			}else{
				for(int i=0;i<bookArray.length;i++){
					System.out.println("Book index [" + counter + "]");
					String textTitle = bookArray[i].getTitle();
					System.out.println(textTitle);
					String textAuthor = bookArray[i].getAuthor();
					System.out.println(textAuthor);
					BigDecimal textPrice = bookArray[i].getPrice();
					System.out.println(textPrice);
					System.out.println("-------------");
					counter++;
				}
				System.out.println("Do you want to purchase any of the books, yes[1], no[2]");
				buy = false;
				String Answer = null;
				goodAnswer = false;
				number = 0; 
				do {
					if (input.hasNextInt()){
						number = input.nextInt();
						if (number == 1){
							goodAnswer = true;
							buy = true;
						} else if (number == 2){
							goodAnswer = true;
						} else{
							System.out.println("Could not understand you, please give your answer again.");
							goodAnswer = false;
							input.next();
						}
					}else{
						Answer = input.next();
						if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")){
							goodAnswer = true;
							buy = true;
						}else if (Answer.equalsIgnoreCase("no") || Answer.equalsIgnoreCase("n")){
							goodAnswer = true;
						}else{
							System.out.println("Could not understand you, please give your answer again.");
							input.next();
							goodAnswer = false;
						}
					}
				} while (!(goodAnswer));
			}
			if (buy){
				number = 0;
				System.out.println("Select the books you want to buy using their indices, write -1 to exit");
				do {
					if (input.hasNextInt()){
						number = input.nextInt();
						if (number <= bookArray.length && number > 0){
							int[] stock = shopStoreKeeper.buy(bookArray[number-1]);
							if (stock[0] == 0){
								customerShoppingCart.addBookToCart(bookArray[number-1]);
								System.out.println("Book " + number + " added!");
							}else if(stock[0] == 1){
								System.out.println("Sorry, book not in stock!");
							}else{
								System.out.println("Sorry, book does not exist!");
							}
							goodAnswer = false;
						} else if (number == -1){
							goodAnswer = true;
						}else{

							System.out.println("Could not understand you, please give your answer again.");
							goodAnswer = false;
							input.next();
						}
					}
				} while (!(goodAnswer));
			}
		} else if (option == 2){
			Book[] bookArray = shopStoreKeeper.list("");
			int counter = 1;
			if (bookArray.length == 0){
				System.out.println("Sorry, no books in store");
			}else{
				for(int i=0;i<bookArray.length;i++){
					System.out.println("Book index [" + counter + "]");
					String textTitle = bookArray[i].getTitle();
					System.out.println(textTitle);
					String textAuthor = bookArray[i].getAuthor();
					System.out.println(textAuthor);
					BigDecimal textPrice = bookArray[i].getPrice();
					System.out.println(textPrice);
					System.out.println("-------------");
					counter++;
				}

				System.out.println("Do you want to purchase any of the books, yes[1], no[2]");
				buy = false;
				String Answer = null;
				number = 0; 
				do {
					if (input.hasNextInt()){
						number = input.nextInt();
						if (number == 1){
							goodAnswer = true;
							buy = true;
						} else if (number == 2){
							goodAnswer = true;
						} else{
							System.out.println("Could not understand you, please give your answer again.");
							goodAnswer = false;
							input.next();
						}
					}else{
						Answer = input.next();
						if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")){
							goodAnswer = true;
							buy = true;
						}else if (Answer.equalsIgnoreCase("no") || Answer.equalsIgnoreCase("n")){
							goodAnswer = true;
						}else{
							System.out.println("Could not understand you, please give your answer again.");
							input.next();
							goodAnswer = false;
						}
					}
				} while (!(goodAnswer));

			}

			if (buy){
				number = 0;
				System.out.println("Select the books you want to buy using their indices, write -1 to exit");
				do {
					if (input.hasNextInt()){
						number = input.nextInt();
						if (number <= bookArray.length && number > 0){
							int[] stock = shopStoreKeeper.buy(bookArray[number-1]);
							if (stock[0] == 0){
								customerShoppingCart.addBookToCart(bookArray[number-1]);
								System.out.println("Book " + number + " added!");
							}else if(stock[0] == 1){
								System.out.println("Sorry, book not in stock!");
							}else{
								System.out.println("Sorry, book does not exist!");
							}
							goodAnswer = false;
						} else if (number == -1){
							goodAnswer = true;
						}else{

							System.out.println("Could not understand you, please give your answer again.");
							goodAnswer = false;
							input.next();
						}
					}
				} while (!(goodAnswer));
			}
		}else{
			remain = false;
		}

		return remain;
	}

	public static boolean viewCart(Scanner input, ShoppingCart customerShoppingCart){
		int counter = 1;
		boolean remain = true;
		boolean goodAnswer = false;
		int number = 0;
		int option = 0;
		ArrayList<Book> books = customerShoppingCart.getInventory();
		for(int i=0;i<books.size();i++){
			System.out.println("Book index [" + counter + "]");
			String textTitle = books.get(i).getTitle();
			System.out.println(textTitle);
			String textAuthor = books.get(i).getAuthor();
			System.out.println(textAuthor);
			BigDecimal textPrice = books.get(i).getPrice();
			System.out.println(textPrice);
			System.out.println("-------------");
			counter++;
		}
		if (books.size() <= 0){
			System.out.println("Your shopping cart is empty, go back[1]");
			String Answer = null;
			do {
				if (input.hasNextInt()){
					number = input.nextInt();
					if (number == 1){
						goodAnswer = true;
						remain = false;
					}else{
						System.out.println("Could not understand you, please give your answer again.");
						remain = false;
						input.next();
					}
				}else{
					Answer = input.next();
					if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")){
						goodAnswer = true;
						remain = false;
					}else{
						System.out.println("Could not understand you, please give your answer again.");
						goodAnswer = false;
						input.next();
					}
				}
			} while (!(goodAnswer));
			
		}else{
	    System.out.println("Current price for all books: " + customerShoppingCart.getPrice());
		System.out.println("Do you want to remove any of the books, yes[1], go back[2]");
		
		
		String Answer = null;
		do {
			if (input.hasNextInt()){
				number = input.nextInt();
				if (number == 1){
					goodAnswer = true;
					remain = true;
					option = 1;
				} else if (number == 2){
					goodAnswer = true;
					remain = false;
					option = 2;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					remain = false;
					input.next();
				}
			}else{
				Answer = input.next();
				if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")){
					goodAnswer = true;
					remain = true;
					option = 1;
				}else if (Answer.equalsIgnoreCase("go back") || Answer.equalsIgnoreCase("back")){
					goodAnswer = true;
					remain = false;
					option = 2;
				}else{
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			}
		} while (!(goodAnswer));
		if (option == 1){
			System.out.println("Select the book you want to remove using their indices, write -1 to exit");
			number = 0;
			do {
				if (input.hasNextInt()){
					number = input.nextInt();
					if (number <= books.size() && number > 0){
						customerShoppingCart.removeBookToCart(books.get(number-1));
						goodAnswer = true;
					} else if (number == -1){
						goodAnswer = true;
					}else{

						System.out.println("Could not understand you, please give your answer again.");
						goodAnswer = false;
						input.next();
					}
				}
			} while (!(goodAnswer));
		}
		}
		return remain;
	}
	public static boolean checkout(Scanner input, ShoppingCart customerShoppingCart){
		int counter = 1;
		boolean remain = true;
		boolean goodAnswer = false;
		int number = 0;
		ArrayList<Book> books = customerShoppingCart.getInventory();
		System.out.println("Books in your shopping cart");
		System.out.println("**************");
		for(int i=0;i<books.size();i++){
			System.out.println("Book index [" + counter + "]");
			String textTitle = books.get(i).getTitle();
			System.out.println(textTitle);
			String textAuthor = books.get(i).getAuthor();
			System.out.println(textAuthor);
			BigDecimal textPrice = books.get(i).getPrice();
			System.out.println(textPrice);
			System.out.println("-------------");
			counter++;
		}
		System.out.println("That will be " + customerShoppingCart.getPrice());
		System.out.println("Pay and checkout[1], or go back[2]?");
		
		String Answer = null;
		number = 0;
		do {
			if (input.hasNextInt()){
				number = input.nextInt();
				if (number == 1){
					goodAnswer = true;
					remain = false;
				}else if (number == 2){
					goodAnswer = true;
					remain = true;
				}else{
				
					System.out.println("Could not understand you, please give your answer again.");
					remain = true;
					input.next();
				}
			}else{
				Answer = input.next();
				if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y") || Answer.equalsIgnoreCase("pay")){
					goodAnswer = true;
					remain = false;
				}else if (Answer.equalsIgnoreCase("no") || Answer.equalsIgnoreCase("go back") || Answer.equalsIgnoreCase("back")){
					goodAnswer = true;
					remain = true;
				}else{
				
					System.out.println("Could not understand you, please give your answer again.");
					goodAnswer = false;
					input.next();
				}
			}
		} while (!(goodAnswer));
		
		return remain;
	}
	
}
