package com.lingo.lingowords.importer;

import com.lingo.lingowords.domain.Word;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVImporterTest {

    @Test
    void getWords() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("words.csv").getFile());
        WordImporter importer = new CSVImporter(file.getAbsolutePath());
        List<Word> words = importer.getWords();

        assertEquals(10, words.size());
        assertEquals("garage", words.get(0).getWord());
        assertEquals("NL", words.get(0).getLanguage());
        assertEquals(6, words.get(0).getLength());

        assertEquals("stoel", words.get(1).getWord());
        assertEquals("NL", words.get(1).getLanguage());
        assertEquals(5, words.get(1).getLength());
    }
}
