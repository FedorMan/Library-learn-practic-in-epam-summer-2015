package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
    репозиторий книги(ведет работу с бд)
 */
@Repository
@Transactional
public class BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     метод сохраняет книгу в бд
     */
    public void addBook(Book book) {
        this.sessionFactory.getCurrentSession().save(book);
    }

    /**
     метод получает список книг из бд
     */
    public List<Book> listAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    /**
     метод удаляет книгу из бд по ее уникальному идентификатору
     */
    public void removeBook(Integer iD) {
        Book contact = (Book) this.sessionFactory.getCurrentSession().load(Book.class, iD);
        if (null != contact) {
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
    /**
     метод изменяет книгу из бд по ее уникальному идентификатору
     */
    public void correctBook(Integer iD, Book book) {
        Book contact = (Book) this.sessionFactory.getCurrentSession().load(Book.class, iD);
        if (null != contact) {
            contact.setName(book.getName());
            contact.setAbout(book.getAbout());
            contact.setGenre(book.getGenre());
            contact.setAuthor(book.getAuthor());
            contact.setYear(book.getYear());
            contact.setCount(book.getCount());
            contact.setRating(book.getRating());
            this.sessionFactory.getCurrentSession().update(contact);
        }
    }

}

