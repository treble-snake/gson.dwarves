package gson.deserialize;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Dwarf;
import model.FacialHair;
import model.Weapon;

import java.lang.reflect.Type;
import java.util.List;

public class DwafDeserializerWithTypeAdapter implements JsonDeserializer<Dwarf>
{
	@Override
	public Dwarf deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
			JsonParseException
	{
		JsonObject jsonObject = json.getAsJsonObject();

		Dwarf dwarf = new Dwarf();
		dwarf.setDwarfAge(jsonObject.get("age").getAsInt());

		dwarf.setFacialHair((FacialHair) context.deserialize(jsonObject.get("facialHair"), FacialHair.class));

		Type weaponsType = new TypeToken<List<Weapon>>()
		{
		}.getType();
		List<Weapon> weapons = context.deserialize(
				jsonObject.getAsJsonArray("weapons"), weaponsType);
		dwarf.addWeapons(weapons);

		return dwarf;
	}
}
