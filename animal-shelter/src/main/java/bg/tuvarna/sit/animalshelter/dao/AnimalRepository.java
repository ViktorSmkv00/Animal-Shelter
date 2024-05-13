package bg.tuvarna.sit.animalshelter.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import bg.tuvarna.sit.animalshelter.model.Animal;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("animalRepository")
public class AnimalRepository implements AnimalDao{
    private static AnimalRepository instance;
    private static final String FILENAME = "C:\\Users\\vikto\\IdeaProjects\\animal-shelter\\animal-shelter\\src\\main\\resources\\animals.xml";
    private static List<Animal> animals = new ArrayList<>();

    public static synchronized AnimalRepository getInstance() {
        if(instance == null){
            instance = new AnimalRepository();
        }
        return instance;
    }

    @Override
    public int insertAnimal(UUID id, Animal animal) {
        animals.add(new Animal(id, animal.getType(), animal.getName(), animal.getDate()));
        saveDataToXml();
        return 0;
    }

    @Override
    public List<Animal> showAllAnimals() {
        return animals;
    }

    @Override
    public List<Animal> getAnimalsByType(String type) {
        List<Animal> animalsSameType = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getType().equals(type)) {
                animalsSameType.add(animal);
            }
        }
        return animalsSameType;
    }

    @Override
    public Optional<Animal> getAnimalById(UUID id) {
        return animals.stream()
                .filter(animal -> animal.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteAnimalById(UUID id) {
        Optional<Animal> animalMaybe = getAnimalById(id);
        if(animalMaybe.isEmpty()){
            return 0;
        }
        animals.remove(animalMaybe.get());
        saveDataToXml();
        return 1;
    }

    @Override
    public int updateAnimalById(UUID id, Animal update) {
        return getAnimalById(id)
                .map(animal -> {
                    int indexOfAnimalToUpdate = animals.indexOf(animal);
                    if(indexOfAnimalToUpdate >= 0){
                        animals.set(indexOfAnimalToUpdate, new Animal(id, update.getType(),
                                update.getName(), update.getDate()));
                        saveDataToXml();
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    private void saveDataToXml() {
        XStream xStream = new XStream(new DomDriver());
        try(FileWriter writer = new FileWriter(FILENAME)){
            xStream.toXML(animals, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataFromXml() {
        XStream xStream = new XStream(new DomDriver());
        File file = new File(FILENAME);
        if(file.exists()){
            try(FileReader reader = new FileReader(file)){
                animals = (List<Animal>) xStream.fromXML(reader);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }


}
