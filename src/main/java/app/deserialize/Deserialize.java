package app.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.deserialize.DwafDeserializer;
import gson.deserialize.DwarvesBandDeserializer;
import gson.deserialize.FacialHairDeserializer;
import gson.serialize.DwarfSerializerWithoutName;
import gson.serialize.DwarvesBandSerializer;
import gson.serialize.FacialHairSerializer;
import model.Dwarf;
import model.DwarvesBand;
import model.FacialHair;
import utils.BandUtil;

public class Deserialize
{
	public static void main(String[] args)
	{
		DwarvesBand company = BandUtil.createBand();

		Gson gson;
		gson = new GsonBuilder()
				.registerTypeAdapter(Dwarf.class, new DwarfSerializerWithoutName())
				.registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
				.registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
				.create();
		String json = gson.toJson(company);

		gson = new GsonBuilder()
				.registerTypeAdapter(DwarvesBand.class, new DwarvesBandDeserializer())
				.registerTypeAdapter(FacialHair.class, new FacialHairDeserializer())
				.registerTypeAdapter(Dwarf.class, new DwafDeserializer())
				.create();
		DwarvesBand bandIsBack = gson.fromJson(json, DwarvesBand.class);

		gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		System.out.println(gson.toJson(bandIsBack));
	}
}
