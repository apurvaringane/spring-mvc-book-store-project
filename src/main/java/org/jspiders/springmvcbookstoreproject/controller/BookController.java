package org.jspiders.springmvcbookstoreproject.controller;

import jakarta.validation.Valid;
import org.jspiders.springmvcbookstoreproject.model.Book;
import org.jspiders.springmvcbookstoreproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String getHomePage()
    {
        return "home";
    }

    @GetMapping("/bookhome")
    public String getAllBook(Model model)
    {
        model.addAttribute("books",service.getAllBook());
        return "bookhome";
    }

    @GetMapping("/get-book-form")
    public String getBookForm(Model model)
    {
        model.addAttribute("books",new Book());
        return "bookform";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book)
    {
        service.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id)
    {
        model.addAttribute("updatebook",service.getBookById(id));
        return "updatebook";
    }

    @PostMapping("/update-book")
    public String updateBook(Book book)
    {
        service.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        service.deleteBookById(id);
        return "redirect:/";
    }


    @GetMapping("/search")
    public String searchProduct(Model model, @RequestParam(name = "name") String name)
    {
        model.addAttribute("books",service.searchBook(name));
        return "/bookhome";
    }
}
