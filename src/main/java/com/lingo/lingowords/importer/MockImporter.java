package com.lingo.lingowords.importer;

import com.lingo.lingowords.domain.Word;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MockImporter implements WordImporter {
    @Override
    public List<Word> getWords() {
        List<Word> wordList = new ArrayList<Word>();
        wordList.add(new Word("Garage", "NL"));
        return wordList;
    }
}
