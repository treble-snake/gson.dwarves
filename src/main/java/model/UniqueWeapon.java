package model;

public class UniqueWeapon extends Weapon
{
	private String name;
	private String origin;

	public UniqueWeapon()
	{
		super();
	}

	public UniqueWeapon(String type, String name, String origin)
	{
		super(type);
		this.name = name;
		this.origin = origin;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
}
