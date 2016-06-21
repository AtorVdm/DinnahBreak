package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class MaranelloDinnah extends Dinnah {

	@Override
	public List<DinnahSet> getDinnahs() {
		List<DinnahSet> dinnahs = new ArrayList<DinnahSet>();
		List<DinnahRecord> records;

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Маргарита", "46"));
		records.add(new DinnahRecord("4 сыра", "58"));
		records.add(new DinnahRecord("Куриная ", "54"));
		records.add(new DinnahRecord("Куриная с ананасами", "56"));
		records.add(new DinnahRecord("Куриная с грибами", "56"));
		records.add(new DinnahRecord("Барбекю ", "60"));
		records.add(new DinnahRecord("Биф Зинзидер", "57"));
		records.add(new DinnahRecord("Гавайская", "56"));
		records.add(new DinnahRecord("Маранелла", "62"));
		records.add(new DinnahRecord("Пепперони", "56"));
		records.add(new DinnahRecord("Пепперони грибная", "57"));
		records.add(new DinnahRecord("Примавера", "56"));
		records.add(new DinnahRecord("Турецкая", "51"));
		records.add(new DinnahRecord("Сицилийская", "57"));
		records.add(new DinnahRecord("Латерия", "78"));
		records.add(new DinnahRecord("Сальмон", "82"));
		records.add(new DinnahRecord("Ликата", "60"));
		records.add(new DinnahRecord("Овощная", "58"));
		records.add(new DinnahRecord("Бомба", "60"));
		records.add(new DinnahRecord("Детская + подарок", "37"));
		records.add(new DinnahRecord("Фаттория", "136"));
		records.add(new DinnahRecord("Дон Камилло", "138"));
		dinnahs.add(new DinnahSet(records, "Пицца"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Греческий", "40"));
		records.add(new DinnahRecord("Милано", "41"));
		records.add(new DinnahRecord("Римини", "52"));
		records.add(new DinnahRecord("Морской коктейль", "57"));
		records.add(new DinnahRecord("Цезарь", "44"));
		records.add(new DinnahRecord("Пикантный", "42"));
		dinnahs.add(new DinnahSet(records, "Салаты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Бульон куриный", "28"));
		records.add(new DinnahRecord("Солянка", "27"));
		records.add(new DinnahRecord("Окрошка", "29"));
		records.add(new DinnahRecord("Лазанья мясная", "48"));
		records.add(new DinnahRecord("Лазанья куриная", "44"));
		records.add(new DinnahRecord("Паста морская", "59"));
		records.add(new DinnahRecord("Паста Болоньезе", "42"));
		records.add(new DinnahRecord("Обед Делла-каза", "35"));
		records.add(new DinnahRecord("Жюльен Ливиньо", "31"));
		dinnahs.add(new DinnahSet(records, "Блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Чизкейк", "34"));
		records.add(new DinnahRecord("Шоколадно-апельсиновый торт Захер", "23"));
		records.add(new DinnahRecord("Маковый пирог Флоренция", "23"));
		records.add(new DinnahRecord("Шоколадный пирог Брауни", "23"));
		records.add(new DinnahRecord("Шоколадный торт Венеция", "16"));
		records.add(new DinnahRecord("Мороженое", "22"));
		records.add(new DinnahRecord("Мороженое с орехами", "31"));
		records.add(new DinnahRecord("Мороженое с фруктами", "31"));
		dinnahs.add(new DinnahSet(records, "Десерты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Милк шейк", "18"));
		records.add(new DinnahRecord("Фреш апельсин/грейпфрут", "39"));
		dinnahs.add(new DinnahSet(records, "Напитки безалкогольные"));

		printProcess("MARANELLO", true);

		return dinnahs;
	}

	@Override
	protected DinnahSet parseDishes(String url) throws Exception {
		return null;
	}

}
