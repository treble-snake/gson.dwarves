package model;

import java.util.LinkedList;
import java.util.List;

public class DwarvesBand
{
	List<Dwarf> dwarves = new LinkedList<>();

	public List<Dwarf> getDwarves()
	{
		return new LinkedList<>(dwarves);
	}

	public void addDwarf(Dwarf dwarf)
	{
		this.dwarves.add(dwarf);
	}
}
