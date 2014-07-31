package model;

public class Weapon
{
	private String type;

	public Weapon()
	{
		// do nothing
	}

	public Weapon(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
}
