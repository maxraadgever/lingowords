package com.lingo.lingowords.processor;

import com.lingo.lingowords.LingoWordsApplication;
import com.lingo.lingowords.domain.Word;
import com.lingo.lingowords.exporter.WordExporter;
import com.lingo.lingowords.importer.WordImporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordProcessor {

    private static Logger LOG = LoggerFactory
            .getLogger(WordProcessor.class);
    private WordImporter importer;
    private WordExporter exporter;

    @Autowired
    public WordProcessor(WordImporter importer, WordExporter exporter) {
        this.importer = importer;
        this.exporter = exporter;
    }

    public void fromImporterToExporter() {
        List<Word> wordList = importer.getWords();

        LOG.info("Found {} words!", wordList.size());

        wordList = wordList.stream().filter(word -> word.isValid()).collect(Collectors.toList());

        LOG.info("Filter to {} words!", wordList.size());

        exporter.exportWords(wordList);

        LOG.info("Exported to {}", exporter.exportName());
    }


}
