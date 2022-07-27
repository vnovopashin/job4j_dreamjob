package ru.job4j.dreamjob.service;

import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.CandidateStore;

import java.util.Collection;

/**
 * Класс является слоем service и выполняет бизнес логику приложения.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 27.07.2022
 */
public class CandidateService {

    private static final CandidateService INST = new CandidateService();
    private final CandidateStore store = CandidateStore.instOf();

    public Collection<Candidate> findAll() {
        return store.findAll();
    }

    private CandidateService() {

    }

    public static CandidateService instOf() {
        return INST;
    }

    public Candidate findById(int id) {
        return store.findById(id);
    }

    public void add(Candidate candidate) {
        store.add(candidate);
    }

    public void update(Candidate candidate) {
        store.update(candidate);
    }
}
