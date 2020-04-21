package com.lingo.lingowords.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Word")
public class WordTest {

    @Test
    @DisplayName("Length is set by constructor")
    void lengthIsSetByConstructor() {
        Word w = new Word("Garage", "NL");
        assertEquals(6, w.getLength());
    }


    @Test
    @DisplayName("Length is set by setting the word")
    void lengthIsSetBySetWord() {
        Word w = new Word("a", "NL");
        w.setWord("Stoel");
        assertEquals(5, w.getLength());
    }
}
