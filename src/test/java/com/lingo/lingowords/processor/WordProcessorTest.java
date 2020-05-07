package com.lingo.lingowords.processor;

import com.lingo.lingowords.exporter.WordExporter;
import com.lingo.lingowords.importer.WordImporter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WordProcessorTest {

    @Mock
    WordImporter importer;
    @Mock
    WordExporter exporter;

    @Test
    @DisplayName("Call the right function to import and export words")
    void fromImporterToExporter() {

        WordProcessor processor = new WordProcessor(importer, exporter);

        processor.fromImporterToExporter();

        verify(importer, times(1)).getWords();
        verify(exporter, times(1)).exportWords(anyList());

    }
}