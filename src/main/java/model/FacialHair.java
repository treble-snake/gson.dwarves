package model;

public class FacialHair
{
	private boolean haveBeard;
	private boolean haveMustache;
	private String color;

	public FacialHair(boolean haveBeard, boolean haveMustache, String color)
	{
		this.haveBeard = haveBeard;
		this.haveMustache = haveMustache;
		this.color = color;
	}

	public FacialHair()
	{
		haveBeard = false;
		haveMustache = false;
		color = "";
	}

	public boolean isHaveBeard()
	{
		return haveBeard;
	}

	public void setHaveBeard(boolean haveBeard)
	{
		this.haveBeard = haveBeard;
	}

	public boolean isHaveMustache()
	{
		return haveMustache;
	}

	public void setHaveMustache(boolean haveMustache)
	{
		this.haveMustache = haveMustache;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}
}
