package com.project.doit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DBArticle {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String text;

    @Enumerated(value = EnumType.STRING)
    private Colour colour;


    private int reference;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reference", insertable = false, updatable = false)
    private DBUser articleReader;


    public DBArticle() {
    }

    public DBArticle(String text, Colour colour) {
        this.text = text;
        this.colour = colour;
    }


    public DBArticle(String text, Colour colour, int reference) {
        this.text = text;
        this.colour = colour;
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public DBUser getArticleReader() {
        return articleReader;
    }

    public void setArticleReader(DBUser articleReader) {
        this.articleReader = articleReader;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DBArticle)) return false;
        DBArticle dbArticle = (DBArticle) o;
        return getId()==(dbArticle.getId()) && getText().equals(dbArticle.getText()) && getColour().equals(dbArticle.getColour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getColour());
    }

    @Override
    public String toString() {
        return "DBArticle{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", colour=" + colour +
                '}';
    }
}
