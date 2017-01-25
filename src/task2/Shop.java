package task2;

import java.util.HashMap;
import java.util.Map;

public class Shop {
	private HashMap<SportEquipment, Integer> goods;

	public Shop() {
		this.goods = new HashMap<SportEquipment, Integer>();
	}

	public HashMap<SportEquipment, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<SportEquipment, Integer> goods) {
		this.goods = goods;
	}

	public void addNewPosition (SportEquipment se, Integer quantity) {
		this.goods.put(se, quantity);
	}

	public boolean rentUnit (String categoryName, String title, RentUnit ru) {
		for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			SportEquipment se = entry.getKey();
			if (se.getCategory().getCategoryName().equals(categoryName)) {
				if (se.getTitle().equals(title)) {
					if (entry.getValue()>0) {
						entry.setValue(entry.getValue()-1);
						ru.add(se);
						System.out.println("Unit successfully taken");
						return true;
					}
					else { 
						System.out.println("Sorry, we are out of stock on this position");
						return false;
					}
				}
			}
		}
		System.out.println("Sorry, there is no such position in the shop");
		return false;
	}

	public void print() {
		String output = "";
		for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			output += entry.getKey().getCategory().getCategoryName() + " " + entry.getKey().getTitle() + " " + entry.getValue() + "\n";
		}
		System.out.println(output);
	}

}
