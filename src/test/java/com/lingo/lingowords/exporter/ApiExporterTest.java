package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class ApiExporterTest {

    @Mock
    private RestTemplateBuilder builder;

    @Mock
    private RestTemplate template;

    @Test
    void exportWordsUsesThePostForObjectMethod() {
        when(builder.build()).thenReturn(template);
        when(template.postForObject(anyString(), anyList(), any())).thenReturn(true);

        ApiExporter apiExporter = new ApiExporter("test.url", builder);
        List<Word> words = new ArrayList<>();
        words.add(new Word());
        words.add(new Word());

        apiExporter.exportWords(words);

        verify(template, times(1)).postForObject(anyString(), anyList(), any());
    }
}