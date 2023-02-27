package com.workNikArt.workNikArt.utils;

import com.workNikArt.workNikArt.entity.BookEntity;
import com.workNikArt.workNikArt.exception.ValidationExeption;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationExeption {
        if (book.getTitle() == null || book.getTitle().isBlank() || book.getTitle().length() < 2 || book.getTitle().length() > 30) {
            throw new ValidationExeption("Название Книги должно содержать от 2 до 30 символов");
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank() || book.getAuthor().length() < 2 || book.getAuthor().length() > 30) {
            throw new ValidationExeption("Имя или псевдоним автора должен содержать от 2 до 30 символов");
        }
        if (book.getPublishing() == null || book.getPublishing().isBlank() || book.getPublishing().length() < 2 || book.getPublishing().length() > 30) {
            throw new ValidationExeption("Издательство должно содержать от 2 до 30 символов");
        }
        if (book.getYear() == 0 || book.getYear() < 0 || book.getYear() > 2023 || book.getYear() < 868) {
            throw new ValidationExeption("Год публикации не может быть меньше 868 года и больше нынешнего");
        }
        if (book.getTypeBook() == null || book.getTypeBook().isBlank() || book.getTypeBook().length() < 1 || book.getTypeBook().length() > 30) {
            throw new ValidationExeption("Тип книги должен содержать хотя бы один символ");
        }
    }

/*
    public static void validateBookForDelete(BookEntity id) throws ValidationExeption{
        if (id.getId() == null){
            throw new ValidationExeption("Нет такого ID");
        }
    }
*/
}
