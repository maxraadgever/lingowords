package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;
import com.lingo.lingowords.repository.WordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Deprecated
public class DbWordExporter implements WordExporter {
    private WordRepository wordRepository;
    private static Logger LOG = LoggerFactory
            .getLogger(DbWordExporter.class);

    @Autowired
    public DbWordExporter(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void exportWords(List<Word> wordList) {
        wordList.forEach(word -> {
            try {
                wordRepository.save(word);
            } catch (Exception e) {
                LOG.error("Failed to save word: " + word);
                LOG.error(e.getMessage());
            }
        });
    }

    @Override
    public String exportName() {
        return "DB with WordRepository";
    }
}
