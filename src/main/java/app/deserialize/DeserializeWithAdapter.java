package app.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import gson.WeaponsTypeAdapter;
import gson.deserialize.DwafDeserializerWithTypeAdapter;
import gson.deserialize.DwarvesBandDeserializer;
import gson.deserialize.FacialHairDeserializer;
import gson.serialize.DwarfSerializerWithTypeAdapter;
import gson.serialize.DwarvesBandSerializer;
import gson.serialize.FacialHairSerializer;
import model.Dwarf;
import model.DwarvesBand;
import model.FacialHair;
import model.Weapon;
import utils.BandUtil;

import java.lang.reflect.Type;
import java.util.List;

public class DeserializeWithAdapter
{
	public static void main(String[] args)
	{
		DwarvesBand company = BandUtil.createBand();

		Gson gson;
		Type weaponsType = new TypeToken<List<Weapon>>()
		{
		}.getType();

		gson = new GsonBuilder()
				.registerTypeAdapter(Dwarf.class, new DwarfSerializerWithTypeAdapter())
				.registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
				.registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
				.registerTypeAdapter(weaponsType, new WeaponsTypeAdapter())
				.setPrettyPrinting()
				.create();
		String json = gson.toJson(company);
		System.out.println(json);

		gson = new GsonBuilder()
				.registerTypeAdapter(DwarvesBand.class, new DwarvesBandDeserializer())
				.registerTypeAdapter(FacialHair.class, new FacialHairDeserializer())
				.registerTypeAdapter(Dwarf.class, new DwafDeserializerWithTypeAdapter())
				.registerTypeAdapter(weaponsType, new WeaponsTypeAdapter())
				.create();
		DwarvesBand companyIsBack = gson.fromJson(json, DwarvesBand.class);

		gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		System.out.println(gson.toJson(companyIsBack));
	}
}
