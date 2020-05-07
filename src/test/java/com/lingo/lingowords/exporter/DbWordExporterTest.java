package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;
import com.lingo.lingowords.repository.WordRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class DbWordExporterTest {

    @Mock WordRepository wordRepository;

    @Test
    @DisplayName("Export words calls save in the repository for each word")
    void exportWords() {
        DbWordExporter exporter = new DbWordExporter(wordRepository);

        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add (new Word("garage"));
        wordList.add(new Word("stoel"));
        wordList.add(new Word("studie"));

        exporter.exportWords(wordList);

        verify(wordRepository, times(3)).save(any());
    }

    @Test
    @DisplayName("Keep exporting words when saving throws a duplicate error")
    void exportWordsWithFail() {
        when(wordRepository.save(any(Word.class))).thenThrow(new RuntimeException());
        DbWordExporter exporter = new DbWordExporter(wordRepository);

        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add (new Word("garage"));
        wordList.add(new Word("stoel"));
        wordList.add(new Word("studie"));

        exporter.exportWords(wordList);

        verify(wordRepository, times(3)).save(any());
    }

    @Test
    void exportName() {
        DbWordExporter exporter = new DbWordExporter(wordRepository);
        String result = exporter.exportName();
        assertNotEquals(null, result);
    }
}