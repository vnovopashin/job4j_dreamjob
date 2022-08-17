package ru.job4j.dreamjob.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Candidate;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 16.08.2022
 */
public class CandidateDBStoreTest {

    private BasicDataSource basicDataSource;
    private CandidateDBStore store;
    private Candidate candidate;

    @Before
    public void setUp() throws SQLException {
        basicDataSource = new Main().loadPool();
        store = new CandidateDBStore(basicDataSource);
        candidate = new Candidate(0, "Ivanov Ivan", "Java Junior", LocalDateTime.now(), new byte[0]);
        basicDataSource.getConnection()
                .prepareStatement("DELETE FROM candidate")
                .executeUpdate();
    }

    @Test
    public void whenCreateCandidate() {
        store.add(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdateCandidate() {
        store.add(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        candidateInDb.setDescription("Java Senior");
        store.update(candidateInDb);
        Candidate candidateInDbUpdate = store.findById(candidateInDb.getId());
        assertThat(candidateInDbUpdate.getDescription(), is("Java Senior"));
    }

    @Test
    public void whenFindByIdCandidate() {
        store.add(candidate);
        assertThat(store.findById(candidate.getId()), is(candidate));
    }

    @Test
    public void whenFindAll() {
        store.add(candidate);
        assertThat(store.findAll(), is(List.of(candidate)));
    }
}
