package com.team6.academigymraeg.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User taker;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Question> questions;

    @Nullable
    private Integer result;

    @NotNull
    private LocalDateTime date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getTaker() {
        return taker;
    }

    public void setTaker(User taker) {
        this.taker = taker;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    @Nullable
    public Integer getResult() {
        return result;
    }

    public void setResult(@Nullable Integer result) {
        this.result = result;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
