package org.jspiders.springmvcbookstoreproject.service;

import org.jspiders.springmvcbookstoreproject.model.Book;
import org.jspiders.springmvcbookstoreproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

   public List<Book> getAllBook()
   {
       return repository.findAll();
   }

   public Book saveBook(Book book)
   {
       return repository.save(book);
   }

    public Book getBookById(int id)
    {
        return repository.findById(id).orElse(null);
    }

    public void deleteBookById(int id)
    {
        repository.deleteById(id);
    }

    public List<Book> searchBook(String name)
    {
        return repository.searchBook(name);
    }
}
