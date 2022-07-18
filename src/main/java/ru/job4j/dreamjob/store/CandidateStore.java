package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс является хранилищем данных, данное хранилище является синглетоном.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 18.07.2022
 */
public class CandidateStore {
    private static final CandidateStore INST = new CandidateStore();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Tom", "Junior Java"));
        candidates.put(2, new Candidate(2, "John", "Middle Java"));
        candidates.put(3, new Candidate(3, "Piter", "Senior Java Job"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }
}
