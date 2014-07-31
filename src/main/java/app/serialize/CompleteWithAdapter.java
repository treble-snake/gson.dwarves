package app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import gson.WeaponsTypeAdapter;
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

public class CompleteWithAdapter
{
	public static void main(String[] args)
	{
		DwarvesBand company = BandUtil.createBand();

		Type weaponsListType = new TypeToken<List<Weapon>>()
		{
		}.getType();
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(Dwarf.class, new DwarfSerializerWithTypeAdapter())
				.registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
				.registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
				.registerTypeAdapter(weaponsListType, new WeaponsTypeAdapter())
				.create();
		String json = gson.toJson(company);

		System.out.println(json);
	}
}
