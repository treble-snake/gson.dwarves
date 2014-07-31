package gson.deserialize;

import com.google.gson.*;
import model.Dwarf;
import model.DwarvesBand;

import java.lang.reflect.Type;
import java.util.Map;

public class DwarvesBandDeserializer implements JsonDeserializer<DwarvesBand>
{
	@Override
	public DwarvesBand deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
			JsonParseException
	{
		DwarvesBand result = new DwarvesBand();
		JsonObject jsonObject = json.getAsJsonObject();

		for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet())
		{
			Dwarf dwarf = context.deserialize(entry.getValue(), Dwarf.class);
			dwarf.setName(entry.getKey());
			result.addDwarf(dwarf);
		}

		return result;
	}
}
