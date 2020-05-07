package com.lingo.lingowords.importer;

import com.lingo.lingowords.domain.Word;

import java.util.ArrayList;
import java.util.List;

public class MockImporter implements WordImporter {
    @Override
    public List<Word> getWords() {
        List<Word> wordList = new ArrayList<>();
        wordList.add(new Word("Garage", "NL"));
        return wordList;
    }
}
