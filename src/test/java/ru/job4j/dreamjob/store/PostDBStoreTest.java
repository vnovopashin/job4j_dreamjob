package ru.job4j.dreamjob.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 14.08.2022
 */
public class PostDBStoreTest {

    private BasicDataSource basicDataSource;
    private PostDBStore store;
    private Post post;

    @Before
    public void setUp() throws SQLException {
        basicDataSource = new Main().loadPool();
        store = new PostDBStore(basicDataSource);
        post = new Post(0, "Ivanov Ivan", "Java Junior",
                true, LocalDateTime.now(), new City(0, "Moscow"));
        basicDataSource.getConnection()
                .prepareStatement("DELETE FROM post")
                .executeUpdate();
    }

    @Test
    public void whenCreatePost() {
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        store.add(post);
        Post postInDb = store.findById(post.getId());
        postInDb.setName("Java SuperJob");
        store.update(postInDb);
        Post postInDbUpdate = store.findById(postInDb.getId());
        assertThat(postInDbUpdate.getName(), is("Java SuperJob"));
    }

    @Test
    public void whenFindByIdCandidate() {
        store.add(post);
        assertThat(store.findById(post.getId()), is(post));
    }

    @Test
    public void whenFindAll() {
        store.add(post);
        assertThat(store.findAll(), is(List.of(post)));
    }
}
