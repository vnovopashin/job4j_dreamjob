package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.store.CityStore;

import java.util.List;


/**
 * Класс является слоем service и выполняет бизнес логику приложения.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 02.08.2022
 */

@Service
@ThreadSafe
public class CityService {
    private final CityStore store;

    public CityService(CityStore store) {
        this.store = store;
    }

    public List<City> getAllCities() {
        return store.getAllCities();
    }

    public City findById(int id) {
        return store.findById(id);
    }
}
