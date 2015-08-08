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

/**
  контроллер для работы с книгами(добавление,удаление,изменение,получение списка,подача шаблона в форму)
 */
@Controller
public class BookController {

    private BookRepository bookRepository;
    public static int numberBook;

    @Autowired
    public BookController(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    /**
    метод предает список книг из бд на главную страницу
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = this.bookRepository.listAll();
        model.addAttribute("books", books);
        return "index";
    }

    /**
    метод предает шаблон книги на страниц для формы при ее добавлении
     */
    @RequestMapping(value = "addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());

        return "addBook";
    }

    /**
    метод предает введеную книгу в репозиторий для дальнейшей записи в бд
     */
    @RequestMapping(value = "addBook", method = RequestMethod.POST)

    public String addBook(@ModelAttribute("book") Book book) {
        this.bookRepository.addBook(book);
        return "redirect:/";
    }

    /**
     метод получает уникальный номер книги и предает его в репозиторий для дальнейшего удаления
     */
    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id) {
        this.bookRepository.removeBook(id);

        return "redirect:/";
    }


    /**
    метод получает уникальный номер книги и ее параметры затем передает эту книгу в форму для корректировки данных
     */
    @RequestMapping(value = "correctBook/{id}/{name}/{author}/{year}/{genre}/{about}/{count}/{rating}", method = RequestMethod.GET)
    public String correctBook(Model model, @PathVariable Integer id, @PathVariable String name, @PathVariable String author, @PathVariable int year, @PathVariable String genre, @PathVariable String about, @PathVariable int count, @PathVariable int rating) {
        numberBook = id;
        Book book = new Book();
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

    /**
     метод передает введенную книгу в репозиторий для записи в бд
     */
    @RequestMapping(value = "correctBook/{id}/{name}/{author}/{year}/{genre}/{about}/{count}/{rating}", method = RequestMethod.POST)
    public String correctBook(@ModelAttribute("book") Book book) {
        this.bookRepository.correctBook(numberBook, book);
        return "redirect:/";
    }
}
