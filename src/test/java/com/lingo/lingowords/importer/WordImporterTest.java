package com.lingo.lingowords.importer;

import com.lingo.lingowords.domain.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordImporterTest {

    private final List<Word> wordList = new ArrayList<Word>();

    @BeforeEach
    public void init() {
        wordList.add(new Word("Garage", "NL"));
    }

    @Test
    void mockImporterTest() {
        WordImporter importer = new MockImporter();

        List<Word> words = importer.getWords();
        assertEquals(1, words.size());
        assertEquals(wordList.get(0).getWord(), words.get(0).getWord());
    }
}
