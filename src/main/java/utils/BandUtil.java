package utils;

import model.*;

public class BandUtil
{
	public static DwarvesBand createBand()
	{
		DwarvesBand company = new DwarvesBand();

		Dwarf tmpDwarf;

		tmpDwarf = new Dwarf("Orin", 90);
		tmpDwarf.setLunch("Ale with chicken");
		tmpDwarf.setFacialHair(new FacialHair(true, true, "black"));
		tmpDwarf.addWeapon(new UniqueWeapon("sword", "Slasher", "Gondolin"));
		tmpDwarf.addWeapon(new UniqueWeapon("shield", "Oaken Shield", "Moria"));
		tmpDwarf.addWeapon(new Weapon("dagger"));
		company.addDwarf(tmpDwarf);

		tmpDwarf = new Dwarf("Kori", 60);
		// no lunch :(
		tmpDwarf.setFacialHair(new FacialHair(false, true, "red"));
		tmpDwarf.addWeapon(new Weapon("mace"));
		tmpDwarf.addWeapon(new Weapon("bow"));
		company.addDwarf(tmpDwarf);

		tmpDwarf = new Dwarf("Billy Bob", 45);
		tmpDwarf.setLunch("Ale with chicken and potatoes, tea with some cakes");
		tmpDwarf.setFacialHair(new FacialHair(false, false, ""));
		company.addDwarf(tmpDwarf);

		return company;
	}
}
