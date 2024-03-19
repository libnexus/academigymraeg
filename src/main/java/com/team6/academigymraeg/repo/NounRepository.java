package com.team6.academigymraeg.repo;


import com.team6.academigymraeg.model.Noun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NounRepository extends CrudRepository<Noun, Integer> {
    int countByNounID (int nounID);
}
