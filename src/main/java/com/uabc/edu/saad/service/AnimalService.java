package com.uabc.edu.saad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.uabc.edu.saad.exception.RecordNotFoundException;
import com.uabc.edu.saad.model.AnimalEntity;
import com.uabc.edu.saad.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository repository;

    public List<AnimalEntity> getAllAnimals() {
        List<AnimalEntity> result = (List<AnimalEntity>) repository.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<AnimalEntity>();
        }
    }

    public AnimalEntity getAnimalById(Long id) throws RecordNotFoundException {
        Optional<AnimalEntity> animal = repository.findById(id);
        if (animal.isPresent()) {
            return animal.get();
        } else {
            throw new RecordNotFoundException("No animal record exist for given id");
        }
    }

    public AnimalEntity createOrUpdateAnimal(AnimalEntity entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);
            return entity;
        } else {
            Optional<AnimalEntity> animal = repository.findById(entity.getId());
            if (animal.isPresent()) {
                AnimalEntity newEntity = animal.get();
                newEntity.setTipo(entity.getTipo());
                newEntity.setRaza(entity.getRaza());
                newEntity.setColor(entity.getColor());
                newEntity.setPelaje(entity.getPelaje());
                newEntity.setFechanacimiento(entity.getFechanacimiento());
                newEntity.setVacunas(entity.getVacunas());

                newEntity = repository.save(entity);

                return newEntity;
            } else {
                entity = repository.save(entity);
                return entity;
            }
        }
    }

    public void deleteAnimalById(Long id) throws RecordNotFoundException{
        Optional<AnimalEntity> animal = repository.findById(id);
        if(animal.isPresent()){
            repository.deleteById(id);

        } else {
            throw  new RecordNotFoundException("No Animal record exist for given id");
        }
    }

}
