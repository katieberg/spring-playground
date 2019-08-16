package com.galvanize.playground.lessons;

import com.galvanize.playground.Lesson;
import com.galvanize.playground.LessonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getOne(@PathVariable String id){
        Long longID = Long.parseLong(id);
        return this.repository.findById(longID).get();
    }

    @DeleteMapping("/{id}")
    public Lesson delete(@PathVariable String id){
        Long longID = Long.parseLong(id);
        Lesson toDelete = this.repository.findById(longID).get();
        this.repository.deleteById(longID);
        return toDelete;
    }

}