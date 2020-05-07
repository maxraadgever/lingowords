package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;

import java.util.List;

public class MockExporter implements WordExporter{

    @Override
    public void exportWords(List<Word> wordList) {
        // do nothing
    }

    @Override
    public String exportName() {
        return "Mockexporter";
    }
}
