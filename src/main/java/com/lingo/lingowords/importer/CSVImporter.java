package com.lingo.lingowords.importer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.lingo.lingowords.domain.Word;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CSVImporter implements WordImporter {

    private String fileLocation;

    public CSVImporter(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public List<Word> getWords() {
        List<Word> wordList = this.loadObjectList(Word.class, this.fileLocation);

        return wordList;
    }

    private <Word> List<Word> loadObjectList(Class<Word> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new File(fileName);
            MappingIterator<Word> readValues =
                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
