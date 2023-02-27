package com.workNikArt.workNikArt.service;

import com.workNikArt.workNikArt.entity.BookEntity;
import com.workNikArt.workNikArt.exception.ValidationExeption;
import com.workNikArt.workNikArt.repo.BookRepo;
import com.workNikArt.workNikArt.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }
    public BookEntity save(BookEntity book) throws ValidationExeption {
        ValidationUtils.validateBook(book);
        return repo.save(book);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Iterable<BookEntity> getAll(){
        return repo.findAll();
    }
}
