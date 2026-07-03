package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_Place;
import pojo.Location;

public class TestDataBuild {

	public Add_Place addPlacePayLoad(String name,String address) {
		Add_Place ad = new Add_Place();
		ad.setAccuracy(123);
		ad.setAddress(address);
		ad.setName(name);
		ad.setPhone_number("+5678900");
		List<String> myList = new ArrayList<>();
		myList.add("add place");
		myList.add("shop");

		ad.setType(myList);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		ad.setLocation(l);

		return ad;
	}

}
