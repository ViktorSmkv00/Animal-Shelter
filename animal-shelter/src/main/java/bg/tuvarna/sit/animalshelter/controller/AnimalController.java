package bg.tuvarna.sit.animalshelter.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import bg.tuvarna.sit.animalshelter.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bg.tuvarna.sit.animalshelter.service.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/animals")
@RestController
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public void addAnimal(@Valid @NotNull @RequestBody Animal animal){
        animalService.addAnimal(animal);
    }

    @GetMapping
    public List<Animal> showAllAnimals(){
        return animalService.showAllAnimals();
    }

    @GetMapping(path = "Type/{type}")
    public List<Animal> getAnimalByType(@PathVariable("type") String type){
        return animalService.getAnimalsByType(type);
    }

    @GetMapping(path = "{id}")
    public Animal getAnimalById(@PathVariable("id") UUID id){
        return animalService.getAnimalById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAnimalById(@PathVariable("id") UUID id){
        animalService.deleteAnimalById(id);
    }

    @PutMapping(path = "{id}")
    public void updateAnimalById(@PathVariable("id") UUID id, @RequestBody Animal animal){
        animalService.updateAnimalById(id, animal);
    }
}
