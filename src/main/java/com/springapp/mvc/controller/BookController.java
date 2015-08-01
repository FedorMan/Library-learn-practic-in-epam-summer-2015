package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Book;
import com.springapp.mvc.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    private BookRepository bookRepository;
    public static int p;

    @Autowired
    public BookController(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = this.bookRepository.listAll();

        model.addAttribute("books", books);

        return "index";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.GET)

    public String addBook(Model model) {
        model.addAttribute("book", new Book());

        return "addBook";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)

    public String addBook(@ModelAttribute("book") Book book) {
        this.bookRepository.addBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id) {
        this.bookRepository.removeBook(id);

        return "redirect:/";
    }


    @RequestMapping(value = "correctBook/{id}/{name}/{author}/{year}/{genre}/{about}/{count}/{rating}", method = RequestMethod.GET)
    public String correctBook(Model model,@PathVariable Integer id,@PathVariable String name,@PathVariable String author,@PathVariable int year,@PathVariable String genre,@PathVariable String about,@PathVariable int count,@PathVariable int rating) {
        p=id;
        Book book=new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setYear(year);
        book.setGenre(genre);
        book.setAbout(about);
        book.setRating(rating);
        book.setCount(count);


        model.addAttribute("book", book);
        return "correctBook";
    }
    @RequestMapping(value = "correctBook/{id}/{name}/{author}/{year}/{genre}/{about}/{count}/{rating}", method = RequestMethod.POST)
    public String correctBook(@ModelAttribute("book") Book book) {
        this.bookRepository.correctBook(p,book);
        return "redirect:/";
    }
}
