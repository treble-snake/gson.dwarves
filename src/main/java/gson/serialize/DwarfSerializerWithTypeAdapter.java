package gson.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import model.Dwarf;
import model.Weapon;

import java.lang.reflect.Type;
import java.util.List;

public class DwarfSerializerWithTypeAdapter implements JsonSerializer<Dwarf>
{
	@Override
	public JsonElement serialize(Dwarf src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject result = new JsonObject();

		result.addProperty("age", src.getDwarfAge());
		result.add("facialHair", context.serialize(src.getFacialHair()));

		Type weaponsType = new TypeToken<List<Weapon>>()
		{
		}.getType();
		result.add("weapons", context.serialize(src.getWeapons(), weaponsType));

		return result;
	}
}