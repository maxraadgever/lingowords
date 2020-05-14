package com.lingo.lingowords.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Word {

    @Id
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
        }

        if (this.length < 5 || this.length > 7) {
            return false;
        }

        return true;
    }
}
