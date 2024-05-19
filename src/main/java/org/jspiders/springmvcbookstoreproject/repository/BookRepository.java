package org.jspiders.springmvcbookstoreproject.repository;

import org.jspiders.springmvcbookstoreproject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//import java.awt.print.Book;
@Repository
public interface BookRepository extends JpaRepository <Book,Integer> {
    @Query("select b from Book b where b.bookName LIKE %:name% OR b.bookAuthor LIKE %:name% OR b.bookPublication LIKE %:name%")
    List<Book> searchBook(@Param("name") String name);
}
