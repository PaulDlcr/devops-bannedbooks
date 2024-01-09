package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.BannedBook;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.exceptions.BookIdMismatchException;
import org.grostarin.springboot.demorest.exceptions.BookNotFoundException;
import org.grostarin.springboot.demorest.repositories.BannedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BannedBookServices {

    @Autowired
    private BannedBookRepository bannedBookRepository;

    public Iterable<BannedBook> findAll(BookSearch bookSearchDTO) {
        if (bookSearchDTO != null && StringUtils.hasText(bookSearchDTO.title())) {
            return bannedBookRepository.findByTitle(bookSearchDTO.title());
        }
        return bannedBookRepository.findAll();
    }

    public BannedBook findOne(long id) {
        return bannedBookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    public BannedBook create(BannedBook bannedBook) {
        BannedBook bannedBook1 = bannedBookRepository.save(bannedBook);
        return bannedBook1;
    }

    public void delete(long id) {
        bannedBookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bannedBookRepository.deleteById(id);
    }

    public BannedBook updateBook(BannedBook bannedBook, long id) {
        if (bannedBook.getId() != id) {
            throw new BookIdMismatchException();
        }
        bannedBookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bannedBookRepository.save(bannedBook);
    }
}
