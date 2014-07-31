package gson.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import model.Dwarf;
import model.DwarvesBand;

import java.lang.reflect.Type;

public class DwarvesBandSerializer implements JsonSerializer<DwarvesBand>
{
	@Override
	public JsonElement serialize(DwarvesBand src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject result = new JsonObject();
		for (Dwarf dwarf : src.getDwarves())
		{
			result.add(dwarf.getName(), context.serialize(dwarf));
		}
		return result;
	}
}
