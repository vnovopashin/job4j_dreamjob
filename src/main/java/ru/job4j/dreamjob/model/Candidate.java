package ru.job4j.dreamjob.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Модель данных описывающая кандидата
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 18.07.2022
 */
public class Candidate {

    private int id;
    private String name;
    private String description;
    private LocalDateTime created = LocalDateTime.now();

    public Candidate() {

    }

    public Candidate(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
