package gson.deserialize;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import model.FacialHair;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class FacialHairDeserializer implements JsonDeserializer<FacialHair>
{
	@Override
	public FacialHair deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
			JsonParseException
	{
		FacialHair hair = new FacialHair();
		String data = json.getAsString();
		List<String> parts = Arrays.asList(data.split(" "));

		if (parts.contains("beard"))
			hair.setHaveBeard(true);
		if (parts.contains("mustache"))
			hair.setHaveMustache(true);
		if (hair.isHaveBeard() || hair.isHaveMustache())
			hair.setColor(parts.get(0));
		return hair;
	}
}
