package gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import model.UniqueWeapon;
import model.Weapon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WeaponsTypeAdapter extends TypeAdapter<List<Weapon>>
{
	@Override
	public void write(JsonWriter out, List<Weapon> value) throws IOException
	{
		out.beginArray();
		for (Weapon weapon : value)
		{
			if (weapon instanceof UniqueWeapon)
			{
				UniqueWeapon uWeapon = (UniqueWeapon) weapon;

				out.beginObject();
				out.name("name")
						.value(uWeapon.getName() + " from " + uWeapon.getOrigin());
				out.name("type")
						.value(uWeapon.getType());
				out.endObject();
			}
			else
			{
				out.value(weapon.getType());
			}
		}
		out.endArray();
	}

	@Override
	public List<Weapon> read(JsonReader in) throws IOException
	{
		List<Weapon> result = new LinkedList<>();

		in.beginArray();
		while (in.hasNext())
		{
			switch (in.peek())
			{
				case STRING:
					result.add(createCommonWeapon(in));
					break;
				case BEGIN_OBJECT:
					result.add(createUniqueWeapon(in));
					break;
				default:
					in.skipValue();
					break;
			}
		}
		in.endArray();

		return result;
	}


	private Weapon createCommonWeapon(JsonReader in) throws IOException
	{
		return new Weapon(in.nextString());
	}

	private Weapon createUniqueWeapon(JsonReader in) throws IOException
	{
		UniqueWeapon weapon = new UniqueWeapon();
		in.beginObject();
		while (in.hasNext())
		{
			switch (in.nextName())
			{
				case "name":
					String[] tmp = in.nextString().split(" from ");
					weapon.setName(tmp[0]);
					if (tmp.length > 1)
						weapon.setOrigin(tmp[1]);
					break;
				case "type":
					weapon.setType(in.nextString());
					break;
				default:
					in.skipValue();
					break;
			}
		}
		in.endObject();

		return weapon;
	}
}
