package com.lingo.lingowords.importer;

import com.lingo.lingowords.domain.Word;
import org.springframework.boot.ApplicationArguments;

import java.util.List;

public interface WordImporter {

    List<Word> getWords();

}
