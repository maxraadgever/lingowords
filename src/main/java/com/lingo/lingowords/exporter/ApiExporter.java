package com.lingo.lingowords.exporter;

import com.lingo.lingowords.domain.Word;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiExporter implements WordExporter {

    private final String url;
    private final RestTemplateBuilder builder;

    public ApiExporter(String url, RestTemplateBuilder builder) {
        this.url = url;
        this.builder = builder;
    }


    @Override
    public void exportWords(List<Word> wordList) {
        RestTemplate template = builder.build();
        template.postForObject(url, wordList, ResponseEntity.class);
    }

    @Override
    public String exportName() {
        return "Exported to the API";
    }
}
