package bm.bookstore.repository;

import bm.bookstore.entities.BookEntity;

import org.springframework.data.repository.CrudRepository;

public interface IBookRepoJPA extends CrudRepository<BookEntity, Integer> {
}
