package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		
		Shop shop = new Shop();
		readInputFile("input.txt", shop);

		int operationCount = 0;
		String command = "";
		RentUnit ru = new RentUnit();
		
		System.out.println("Commands available: \ntake \"category\" \"title\" \nshowUnitsTaken \nshowUnitsAvailable \nexit");
		
		while (true) {
			System.out.println("Please enter command: ");
			Scanner input = new Scanner(System.in);
			command = input.next();

			switch (command.toLowerCase()) {
			case "take":
				if (operationCount < 3) {
					String categoryName = input.next();
					String unit = input.next();
					if (shop.rentUnit(categoryName, unit, ru))
					{
						operationCount++;
					}
				}
				else {
					System.out.println("Sorry, you can't take more than 3 units");
				}
				break;
			case "showunitstaken":
				ru.print();
				break;
			case "showunitsavailable":
				shop.print();
				break;
			case "exit":
				System.exit(1);
			default:
				System.out.println("Command not recognized");
				break;
			}
		}
	}
	
	public static void readInputFile(String fileName, Shop shop) throws FileNotFoundException {
		
		Scanner in = new Scanner (new File(fileName));
		ArrayList<String> equipmentPositions = new ArrayList<String>();
		while(in.hasNextLine()) {
			equipmentPositions.add(in.nextLine());
		}
		in.close();

		for (String equipmentInfoLine: equipmentPositions) {
			StringTokenizer tokens = new StringTokenizer(equipmentInfoLine, " ");
			int quantity = Integer.parseInt(tokens.nextToken());
			String title = tokens.nextToken();
			String category = tokens.nextToken();
			int price = Integer.parseInt(tokens.nextToken());
			Category cat = new Category(category);
			SportEquipment newAddition = new SportEquipment(cat, title, price);
			shop.addNewPosition(newAddition, quantity);
		}
	}
}
