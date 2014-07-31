package gson.deserialize;

import com.google.gson.*;
import model.Dwarf;
import model.FacialHair;
import model.UniqueWeapon;
import model.Weapon;

import java.lang.reflect.Type;

public class DwafDeserializer implements JsonDeserializer<Dwarf>
{
	@Override
	public Dwarf deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
			JsonParseException
	{
		JsonObject jsonObject = json.getAsJsonObject();

		Dwarf dwarf = new Dwarf();
		dwarf.setDwarfAge(jsonObject.get("age").getAsInt());

		dwarf.setFacialHair((FacialHair) context.deserialize(jsonObject.get("facialHair"), FacialHair.class));

		JsonArray weapons = jsonObject.getAsJsonArray("weapons");
		for (JsonElement weapon : weapons)
		{
			if (weapon.isJsonPrimitive())
			{
				dwarf.addWeapon(new Weapon(weapon.getAsString()));
			}
			else
			{
				dwarf.addWeapon((UniqueWeapon) context.deserialize(weapon, UniqueWeapon.class));
			}
		}

		return dwarf;
	}
}
