package model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Dwarf
{
	private String name;
	private FacialHair facialHair;
	private List<Weapon> weapons = new LinkedList<>();
	private String lunch;
	private int dwarfAge;

	public Dwarf()
	{
	}

	public Dwarf(String name, int dwarfAge)
	{
		this.name = name;
		this.dwarfAge = dwarfAge;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public FacialHair getFacialHair()
	{
		return facialHair;
	}

	public void setFacialHair(FacialHair facialHair)
	{
		this.facialHair = facialHair;
	}

	public List<Weapon> getWeapons()
	{
		return new LinkedList<>(weapons);
	}

	public void addWeapon(Weapon weapon)
	{
		this.weapons.add(weapon);
	}

	public void addWeapons(Collection<Weapon> weapons)
	{
		this.weapons.addAll(weapons);
	}

	public String getLunch()
	{
		return lunch;
	}

	public void setLunch(String lunch)
	{
		this.lunch = lunch;
	}

	public int getDwarfAge()
	{
		return dwarfAge;
	}

	public void setDwarfAge(int dwarfAge)
	{
		this.dwarfAge = dwarfAge;
	}
}
