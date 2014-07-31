package app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.serialize.DwarfSerializer;
import gson.serialize.FacialHairSerializer;
import model.Dwarf;
import model.DwarvesBand;
import model.FacialHair;
import utils.BandUtil;

public class Advanced
{
	public static void main(String[] args)
	{
		DwarvesBand company = BandUtil.createBand();

		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(Dwarf.class, new DwarfSerializer())
				.registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
				.create();
		String json = gson.toJson(company);

		System.out.println(json);
	}
}
