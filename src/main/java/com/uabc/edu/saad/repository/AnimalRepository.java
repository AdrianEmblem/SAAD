package com.uabc.edu.saad.repository;

import com.uabc.edu.saad.model.AnimalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends  CrudRepository< AnimalEntity, Long>{

}
