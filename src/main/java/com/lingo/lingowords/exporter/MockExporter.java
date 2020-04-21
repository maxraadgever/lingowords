package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;
import org.springframework.beans.factory.annotation.Qualifier;

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
