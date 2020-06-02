package com.lingo.lingowords.config;

import com.lingo.lingowords.exporter.ApiExporter;
import com.lingo.lingowords.exporter.DbWordExporter;
import com.lingo.lingowords.exporter.MockExporter;
import com.lingo.lingowords.exporter.WordExporter;
import com.lingo.lingowords.importer.CSVImporter;
import com.lingo.lingowords.importer.MockImporter;
import com.lingo.lingowords.importer.WordImporter;
import com.lingo.lingowords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Configuration
public class AppConfiguration {

    @Autowired
    private ApplicationArguments args;
    @Autowired
    private WordRepository wordRepository;

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

        if (args.getOptionValues("output").size() == 1 && args.getOptionValues("output").get(0).equals("api")) {
            if (args.getOptionValues("apiurl") != null) {
                return new ApiExporter(args.getOptionValues("apiurl").get(0), new RestTemplateBuilder());
            }
        }

        throw new NotImplementedException();
    }
}
