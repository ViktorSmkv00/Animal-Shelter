package bg.tuvarna.sit.animalshelter.service;

import bg.tuvarna.sit.animalshelter.dao.AnimalDao;
import bg.tuvarna.sit.animalshelter.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {
    private AnimalDao animalDao;

    @Autowired
    public AnimalService(@Qualifier("animalRepository") AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public int addAnimal(Animal animal){
        return animalDao.insertAnimal(animal);
    }

    public List<Animal> showAllAnimals(){
        return animalDao.showAllAnimals();
    }

    public List<Animal> getAnimalsByType(String type){
        return animalDao.getAnimalsByType(type);
    }

    public Optional<Animal> getAnimalById(UUID id){
        return animalDao.getAnimalById(id);
    }

    public int deleteAnimalById(UUID id){
        return animalDao.deleteAnimalById(id);
    }

    public int updateAnimalById(UUID id, Animal animal){
        return animalDao.updateAnimalById(id, animal);
    }
}
