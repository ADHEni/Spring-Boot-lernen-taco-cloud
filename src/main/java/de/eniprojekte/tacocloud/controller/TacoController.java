package de.eniprojekte.tacocloud.controller;

import de.eniprojekte.tacocloud.data.Taco;
import de.eniprojekte.tacocloud.interfaces.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "localhost:8080")
public class TacoController {

    private TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepo) {

        this.tacoRepository = tacoRepo;

    }


    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos () {
        PageRequest pageRequest = PageRequest.of(0, 12,
                Sort.by("createdAt").descending());

        return tacoRepository.findAll(pageRequest).getContent();

    }

    @GetMapping("/{id}")
    public Optional<Taco> tacoById (@PathVariable long id) {

        return tacoRepository.findById(id);


    }




}
