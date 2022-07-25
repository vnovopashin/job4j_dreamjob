package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс является хранилищем данных, данное хранилище является синглетоном.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 18.07.2022
 */
public class CandidateStore {

    private final static AtomicInteger CANDIDATE_ID = new AtomicInteger();
    private static final CandidateStore INST = new CandidateStore();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(CANDIDATE_ID.incrementAndGet(), "Tom", "Junior Java"));
        candidates.put(2, new Candidate(CANDIDATE_ID.incrementAndGet(), "John", "Middle Java"));
        candidates.put(3, new Candidate(CANDIDATE_ID.incrementAndGet(), "Piter", "Senior Java Job"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public void add(Candidate candidate) {
        candidate.setId(CANDIDATE_ID.incrementAndGet());
        candidates.putIfAbsent(candidate.getId(), candidate);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId(), candidate);
    }
}
