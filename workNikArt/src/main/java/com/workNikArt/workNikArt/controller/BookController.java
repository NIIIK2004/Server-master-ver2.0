package com.workNikArt.workNikArt.controller;

import com.workNikArt.workNikArt.entity.BookEntity;
import com.workNikArt.workNikArt.response.BaseResponse;
import com.workNikArt.workNikArt.response.BookListResponse;
import com.workNikArt.workNikArt.response.BookResponse;
import com.workNikArt.workNikArt.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponse> registration(@RequestBody BookEntity data) {
        try {
            BookEntity temp = service.save(data);
            return ResponseEntity.ok(new BookResponse(true, "Книга добавлена", temp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "ВСЁ Изменения прошли, красавчик"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Так, угу, не получилось, ну конечно не получится, когда ты набираешь не правильно, посмотри на запрос"));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Наконец-то мы это удалили, ура"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Скорее всего такого ID не существует"));
        }
    }
}