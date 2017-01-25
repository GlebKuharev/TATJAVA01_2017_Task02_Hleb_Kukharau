package task2;

import java.util.ArrayList;

public class RentUnit {
	private ArrayList<SportEquipment> units;
	
	public RentUnit() {
		this.units = new ArrayList<SportEquipment>();
	}

	public void add(SportEquipment se) {
		units.add(se);
	}

	public void print() {
		String output = "";
		for (SportEquipment sp : units) {
			output += sp.getCategory().getCategoryName() + " " + sp.getTitle() + "\n";
		}
		System.out.println(output);
	}
	
}
