package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;

import java.util.List;

public interface WordExporter {

    void exportWords(List<Word> wordList);
    String exportName();

}
