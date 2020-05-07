package com.lingo.lingowords;

import com.lingo.lingowords.processor.WordProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LingoWordsApplication implements ApplicationRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(LingoWordsApplication.class);
    @Autowired
    private WordProcessor wordProcessor;

    public static void main(String[] args) {
        SpringApplication.run(LingoWordsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("EXECUTING");
        wordProcessor.fromImporterToExporter();
    }
}
