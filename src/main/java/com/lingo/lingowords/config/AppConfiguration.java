package com.lingo.lingowords.config;

import com.lingo.lingowords.exporter.ApiExporter;
import com.lingo.lingowords.exporter.MockExporter;
import com.lingo.lingowords.exporter.WordExporter;
import com.lingo.lingowords.importer.CSVImporter;
import com.lingo.lingowords.importer.MockImporter;
import com.lingo.lingowords.importer.WordImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Autowired
    private ApplicationArguments args;

    @Bean
    public WordImporter wordImporter() {
        if (args.getOptionValues("file") == null) {
            return new MockImporter();
        }

        String fileName = args.getOptionValues("file").get(0);
        return new CSVImporter(fileName);

    }

    @Bean
    public WordExporter wordExporter() {
        if (args.getOptionValues("output") == null) {
            return new MockExporter();
        }

        if (args.getOptionValues("output").size() == 1
                && args.getOptionValues("output").get(0).equals("api")
                && args.getOptionValues("apiurl") != null) {
            return new ApiExporter(args.getOptionValues("apiurl").get(0), new RestTemplateBuilder());
        }


        throw new RuntimeException("Exporter not supported");
    }
}
