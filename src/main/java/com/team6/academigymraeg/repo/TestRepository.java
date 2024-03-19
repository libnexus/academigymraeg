package com.team6.academigymraeg.repo;

import com.team6.academigymraeg.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
    int countByTaker(Test taker);

}
