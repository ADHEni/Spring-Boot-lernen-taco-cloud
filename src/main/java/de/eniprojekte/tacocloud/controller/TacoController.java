package de.eniprojekte.tacocloud.controller;

import de.eniprojekte.tacocloud.data.Ingredient;
import de.eniprojekte.tacocloud.data.Taco;
import de.eniprojekte.tacocloud.interfaces.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "localhost:8080")
public class TacoController {

    private final RestTemplate restTemplate;
    private TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepo, RestTemplate restTemplate) {

        this.tacoRepository = tacoRepo;
        this.restTemplate = restTemplate;
    }


    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos () {
        PageRequest pageRequest = PageRequest.of(0, 12,
                Sort.by("createdAt").descending());

        return tacoRepository.findAll(pageRequest).getContent();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable long id) {

        Optional<Taco> taco = tacoRepository.findById(id);

        if(taco.isPresent()) {
            return ResponseEntity.ok(taco.get());
        }

        return ResponseEntity.notFound().build();


    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco createTaco(@RequestBody Taco taco) {

        return tacoRepository.save(taco);


    }





}
