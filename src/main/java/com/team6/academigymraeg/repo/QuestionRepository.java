package com.team6.academigymraeg.repo;

import com.team6.academigymraeg.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {


    int countByQuestion(String question);
}
