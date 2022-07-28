package ru.job4j.dreamjob.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс является хранилищем данных.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 17.07.2022
 */

@Repository
public class PostStore {

    private final static AtomicInteger POST_ID = new AtomicInteger();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostStore() {
        posts.put(1, new Post(POST_ID.incrementAndGet(), "Junior Java Job", "Навыки разработки на java"));
        posts.put(2, new Post(POST_ID.incrementAndGet(), "Middle Java Job", "Разработка ПО\n"
                + "Ревью изменений в репозитории, участие в диагностике ошибок"));
        posts.put(3, new Post(POST_ID.incrementAndGet(), "Senior Java Job", "Координирование разработки внутри команды,"
                + " ревью всех изменений в репозитории, скрипты сборки,"
                + " участие в диагностике ошибок, участие в экспертном сообществе "));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void add(Post post) {
        post.setId(POST_ID.incrementAndGet());
        posts.putIfAbsent(post.getId(), post);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }
}
