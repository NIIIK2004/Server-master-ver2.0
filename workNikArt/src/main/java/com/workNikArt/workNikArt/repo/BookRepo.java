package com.workNikArt.workNikArt.repo;

import com.workNikArt.workNikArt.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
}
