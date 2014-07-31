package gson.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import model.FacialHair;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class FacialHairSerializer implements JsonSerializer<FacialHair>
{
	@Override
	public JsonElement serialize(FacialHair src, Type typeOfSrc, JsonSerializationContext context)
	{
		if (!src.isHaveBeard() && !src.isHaveMustache())
			return new JsonPrimitive("is he really a dwarf?");

		List<String> list = new LinkedList<>();
		if (src.isHaveBeard())
		{
			list.add("beard");
		}
		if (src.isHaveMustache())
		{
			list.add("mustache");
		}

		return new JsonPrimitive(
				new StringBuilder(src.getColor())
						.append(" ")
						.append(StringUtils.join(list, " and "))
						.toString()
		);
	}
}
