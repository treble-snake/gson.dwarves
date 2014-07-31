package app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.serialize.DwarfSerializerWithoutName;
import gson.serialize.DwarvesBandSerializer;
import gson.serialize.FacialHairSerializer;
import model.Dwarf;
import model.DwarvesBand;
import model.FacialHair;
import utils.BandUtil;

public class Complete
{
	public static void main(String[] args)
	{
		DwarvesBand company = BandUtil.createBand();

		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(Dwarf.class, new DwarfSerializerWithoutName())
				.registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
				.registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
				.create();
		String json = gson.toJson(company);

		System.out.println(json);
	}
}
