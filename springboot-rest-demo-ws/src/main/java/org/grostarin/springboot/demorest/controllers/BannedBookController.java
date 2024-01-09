package org.grostarin.springboot.demorest.controllers;

import javax.validation.Valid;

import org.grostarin.springboot.demorest.annotations.LogExecutionTime;
import org.grostarin.springboot.demorest.domain.BannedBook;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.services.BannedBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bannedbooks")
public class BannedBookController {

    @Autowired
    private BannedBookServices bannedBookServices;

    @GetMapping
    @LogExecutionTime
    public Iterable<BannedBook> findAll(@Valid BookSearch bookSearchDTO) {
        return bannedBookServices.findAll(bookSearchDTO);
    }

    @GetMapping("/{id}")
    public BannedBook findOne(@PathVariable long id) {
        return bannedBookServices.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BannedBook create(@RequestBody BannedBook bannedBook) {
        return bannedBookServices.create(bannedBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bannedBookServices.delete(id);
    }

    @PutMapping("/{id}")
    public BannedBook updateBook(@RequestBody BannedBook bannedBook, @PathVariable long id) {
        return bannedBookServices.updateBook(bannedBook, id);
    }
}
