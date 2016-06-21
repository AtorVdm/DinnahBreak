package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class TeremokDinnah extends Dinnah {

	@Override
	public List<DinnahSet> getDinnahs() {
		List<DinnahSet> dinnahs;
		List<DinnahRecord> records;

		dinnahs = new ArrayList<DinnahSet>();
		records = new ArrayList<DinnahRecord>();

		dinnahs.add(new DinnahSet(records, "Понедельник/Вторник"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Борщ украинский", "12"));
		records.add(new DinnahRecord("Солянка", "16"));
		records.add(new DinnahRecord("Окрошка", "20"));
		records.add(new DinnahRecord("Суп гороховый", "11"));
		records.add(new DinnahRecord("Закуска из сала с чесноком", "4"));
		records.add(new DinnahRecord("Печеночный паштет", "2"));
		dinnahs.add(new DinnahSet(records, "Первые блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Пюре", "8"));
		records.add(new DinnahRecord("Артек", "7"));
		records.add(new DinnahRecord("Макароны по-флотски", "11"));
		records.add(new DinnahRecord("Ризотто с овощами", "11"));
		dinnahs.add(new DinnahSet(records, "Гарниры"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Колбаски домашние", "20"));
		records.add(new DinnahRecord("Гуляш говяжий", "18"));
		records.add(new DinnahRecord("Гуляш из свинины", "18"));
		records.add(new DinnahRecord("Отбивная свиная", "22"));
		records.add(new DinnahRecord("Отбивная свиная с грибами под сыром", "24"));
		records.add(new DinnahRecord("Котлета домашняя", "13"));
		records.add(new DinnahRecord("Печень жареная с луком", "13"));
		records.add(new DinnahRecord("Отбивная куриная", "17"));
		records.add(new DinnahRecord("Тефтели", "13"));
		records.add(new DinnahRecord("Пельмени", "22"));
		records.add(new DinnahRecord("Пельмени по-царски", "26"));
		records.add(new DinnahRecord("Вареники с мясом", "26"));
		records.add(new DinnahRecord("Яичница", "8"));
		records.add(new DinnahRecord("Омлет с овощами, сыром и отварным куриным мясом ", "16"));
		dinnahs.add(new DinnahSet(records, "Мясные блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Сельдь с луком", "17"));
		records.add(new DinnahRecord("Сельд под шубой", "11"));
		records.add(new DinnahRecord("Мимоза", "11"));
		records.add(new DinnahRecord("Свежая капустка с огурцами", "10"));
		records.add(new DinnahRecord("Кашеная капуста", "9"));
		records.add(new DinnahRecord("Крабовый салат", "13"));
		records.add(new DinnahRecord("Столичный салат", "13"));
		records.add(new DinnahRecord("Грузинский салат", "13"));
		records.add(new DinnahRecord("Овощной", "10"));
		records.add(new DinnahRecord("Свекла отварная", "7"));
		dinnahs.add(new DinnahSet(records, "Салаты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Блинчики сладкие", "14"));
		records.add(new DinnahRecord("Блинчики с мясом", "14"));
		records.add(new DinnahRecord("Узвар", "5"));
		records.add(new DinnahRecord("Мороженое с фруктами", "25"));
		dinnahs.add(new DinnahSet(records, "Десерты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Картофель жарен. с луком", "15"));
		records.add(new DinnahRecord("Пицца сборная", "40"));
		records.add(new DinnahRecord("Ромштекс из говяжьей вырезки", "25"));
		records.add(new DinnahRecord("Жаркое", "35"));
		dinnahs.add(new DinnahSet(records, "Под заказ (20 мин)"));

		records = new ArrayList<DinnahRecord>();
		dinnahs.add(new DinnahSet(records, "Среда/Четверг"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Солянка", "16"));
		records.add(new DinnahRecord("Окрошка", "20"));
		records.add(new DinnahRecord("Харчо", "13"));
		records.add(new DinnahRecord("Суп с фрикадельками", "13"));
		records.add(new DinnahRecord("Уха с семгой", "14"));
		records.add(new DinnahRecord("Закуска из сала с чесноком", "4"));
		records.add(new DinnahRecord("Печеночный паштет", "2"));
		dinnahs.add(new DinnahSet(records, "Первые блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Пюре", "8"));
		records.add(new DinnahRecord("Макарончики", "7"));
		records.add(new DinnahRecord("Плов", "15"));
		records.add(new DinnahRecord("Гречневая кашка", "8"));
		records.add(new DinnahRecord("Картофель запеченный с салом", "11"));
		dinnahs.add(new DinnahSet(records, "Гарниры"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Колбаски домашние", "20"));
		records.add(new DinnahRecord("Голубцы", "14"));
		records.add(new DinnahRecord("Рыбная котлета", "15"));
		records.add(new DinnahRecord("Зразы с мясом ", "13"));
		records.add(new DinnahRecord("Отбивная куриная", "17"));
		records.add(new DinnahRecord("Котлета по-киевски", "18"));
		records.add(new DinnahRecord("Домашняя котлета", "13"));
		records.add(new DinnahRecord("Отбивная из говядины", "22"));
		records.add(new DinnahRecord("Отбивная говяжья с грибами под сыром", "24"));
		records.add(new DinnahRecord("Яичница с беконом", "11"));
		records.add(new DinnahRecord("Пельмени", "22"));
		records.add(new DinnahRecord("Пельмени по-царски", "26"));
		records.add(new DinnahRecord("Вареники с мясом", "26"));
		records.add(new DinnahRecord("Яичница", "8"));
		records.add(new DinnahRecord("Омлет с овощами, сыром и отварным куриным мясом ", "16"));
		dinnahs.add(new DinnahSet(records, "Мясные блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Сельдь с луком", "17"));
		records.add(new DinnahRecord("Сельд под шубой", "11"));
		records.add(new DinnahRecord("Мимоза", "11"));
		records.add(new DinnahRecord("Свежая капустка с огурцами", "10"));
		records.add(new DinnahRecord("Кашеная капуста", "9"));
		records.add(new DinnahRecord("Крабовый салат", "13"));
		records.add(new DinnahRecord("Столичный салат", "13"));
		records.add(new DinnahRecord("Грузинский салат", "13"));
		records.add(new DinnahRecord("Овощной", "10"));
		records.add(new DinnahRecord("Свекла отварная", "7"));
		dinnahs.add(new DinnahSet(records, "Салаты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Блинчики сладкие", "14"));
		records.add(new DinnahRecord("Блинчики с мясом", "14"));
		records.add(new DinnahRecord("Узвар", "5"));
		records.add(new DinnahRecord("Мороженое с фруктами", "25"));
		dinnahs.add(new DinnahSet(records, "Десерты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Картофель жарен. с луком", "15"));
		records.add(new DinnahRecord("Пицца сборная", "40"));
		records.add(new DinnahRecord("Ромштекс из говяжьей вырезки", "25"));
		records.add(new DinnahRecord("Жаркое", "35"));
		dinnahs.add(new DinnahSet(records, "Под заказ (20 мин)"));

		records = new ArrayList<DinnahRecord>();
		dinnahs.add(new DinnahSet(records, "Пятница/Суббота"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Борщ украинский", "12"));
		records.add(new DinnahRecord("Солянка", "16"));
		records.add(new DinnahRecord("Окрошка", "20"));
		records.add(new DinnahRecord("Бульон", "10"));
		dinnahs.add(new DinnahSet(records, "Первые блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Пюре", "8"));
		records.add(new DinnahRecord("Артек", "7"));
		records.add(new DinnahRecord("Макароны по-флотски", "11"));
		records.add(new DinnahRecord("Ризотто с овощами", "11"));
		dinnahs.add(new DinnahSet(records, "Гарниры"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Колбаски домашние", "20"));
		records.add(new DinnahRecord("Куриная отбивная по-венгерски", "20"));
		records.add(new DinnahRecord("Зразы с мясом ", "13"));
		records.add(new DinnahRecord("Отбивная куриная", "17"));
		records.add(new DinnahRecord("Котлета по-киевски", "18"));
		records.add(new DinnahRecord("Домашняя котлета", "13"));
		records.add(new DinnahRecord("Отбивная из говядины", "22"));
		records.add(new DinnahRecord("Отбивная говяжья с грибами под сыром", "24"));
		records.add(new DinnahRecord("Яичница с беконом", "11"));
		records.add(new DinnahRecord("Пельмени", "22"));
		records.add(new DinnahRecord("Пельмени по-царски", "26"));
		records.add(new DinnahRecord("Вареники с мясом", "26"));
		records.add(new DinnahRecord("Яичница", "8"));
		records.add(new DinnahRecord("Омлет с овощами, сыром и отварным куриным мясом ", "16"));
		dinnahs.add(new DinnahSet(records, "Мясные блюда"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Сельдь с луком", "17"));
		records.add(new DinnahRecord("Сельд под шубой", "11"));
		records.add(new DinnahRecord("Мимоза", "11"));
		records.add(new DinnahRecord("Свежая капустка с огурцами", "10"));
		records.add(new DinnahRecord("Кашеная капуста", "9"));
		records.add(new DinnahRecord("Крабовый салат", "13"));
		records.add(new DinnahRecord("Столичный салат", "13"));
		records.add(new DinnahRecord("Грузинский салат", "13"));
		records.add(new DinnahRecord("Овощной", "10"));
		records.add(new DinnahRecord("Свекла отварная", "7"));
		dinnahs.add(new DinnahSet(records, "Салаты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Блинчики сладкие", "14"));
		records.add(new DinnahRecord("Блинчики с мясом", "14"));
		records.add(new DinnahRecord("Узвар", "5"));
		records.add(new DinnahRecord("Мороженое с фруктами", "25"));
		dinnahs.add(new DinnahSet(records, "Десерты"));

		records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Картофель жарен. с луком", "15"));
		records.add(new DinnahRecord("Пицца сборная", "40"));
		records.add(new DinnahRecord("Ромштекс из говяжьей вырезки", "25"));
		records.add(new DinnahRecord("Жаркое", "35"));

		return dinnahs;
	}

	@Override
	protected DinnahSet parseDishes(String url) throws Exception {

		return null;
	}
}
