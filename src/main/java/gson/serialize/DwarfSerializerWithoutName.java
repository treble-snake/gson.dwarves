package gson.serialize;

import com.google.gson.*;
import model.Dwarf;
import model.UniqueWeapon;
import model.Weapon;

import java.lang.reflect.Type;

public class DwarfSerializerWithoutName implements JsonSerializer<Dwarf>
{
	@Override
	public JsonElement serialize(Dwarf src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject result = new JsonObject();

		result.addProperty("age", src.getDwarfAge());
		result.add("facialHair", context.serialize(src.getFacialHair()));

		JsonArray weapons = new JsonArray();
		result.add("weapons", weapons);

		for (Weapon weapon : src.getWeapons())
		{
			weapons.add(
					weapon instanceof UniqueWeapon ?
							context.serialize(weapon) :
							new JsonPrimitive(weapon.getType())
			);
		}

		return result;
	}
}
