package com.lingo.lingowords.domain;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String word;
    private int length;
    private String language = "NL";

    public Word(String word, String language) {
        this.word = word;
        this.language = language;
        this.length = word.length();
    }

    public Word(String word) {
        this.word = word;
        this.length = word.length();
    }

    public Word() {}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        this.length = word.length();
    }

    public int getLength() {
        return length;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isValid() {
        if(!this.word.matches("[a-z]+\\.?")) {
            return false;
        } else if (this.length < 5 || this.length > 7) {
            return false;
        }

        return true;
    }
}
