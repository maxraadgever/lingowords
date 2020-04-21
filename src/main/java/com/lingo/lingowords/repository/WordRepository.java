package com.lingo.lingowords.repository;

import com.lingo.lingowords.domain.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
}
