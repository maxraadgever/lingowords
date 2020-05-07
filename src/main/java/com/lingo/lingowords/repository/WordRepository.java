package com.lingo.lingowords.repository;

import com.lingo.lingowords.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface WordRepository extends CrudRepository<Word, Long> {
}
