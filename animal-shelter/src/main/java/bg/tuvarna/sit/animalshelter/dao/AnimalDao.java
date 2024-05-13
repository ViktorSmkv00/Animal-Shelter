package bg.tuvarna.sit.animalshelter.dao;

import bg.tuvarna.sit.animalshelter.model.Animal;

import java.util.*;

public interface AnimalDao {
    int insertAnimal(UUID id, Animal animal);

    default int insertAnimal(Animal animal){
        UUID id = UUID.randomUUID();
        return insertAnimal(id, animal);
    }

    List<Animal> showAllAnimals();
    List<Animal> getAnimalsByType(String type);
    Optional<Animal> getAnimalById(UUID id);

    int deleteAnimalById(UUID id);
    int updateAnimalById(UUID id, Animal animal);

}
