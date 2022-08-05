package ru.job4j.dreamjob.store;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс является хранилищем данных.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 05.08.2022
 */

@Repository
@ThreadSafe
public class CityStore {
    private final static AtomicInteger CITY_ID = new AtomicInteger();
    private final Map<Integer, City> cities = new HashMap<>();

    public CityStore() {
        cities.put(1, new City(CITY_ID.incrementAndGet(), "Москва"));
        cities.put(2, new City(CITY_ID.incrementAndGet(), "СПб"));
        cities.put(3, new City(CITY_ID.incrementAndGet(), "Екб"));
    }

    public List<City> getAllCities() {
        return new ArrayList<>(cities.values());
    }

    public City findById(int id) {
        return cities.get(id);
    }
}
