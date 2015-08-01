package com.springapp.mvc.repository;


import com.springapp.mvc.domain.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CommentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addComment(Comment comment) {
        this.sessionFactory.getCurrentSession().save(comment);
    }

    public List<Comment> listAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Comment").list();
    }

    public void removeComment(Integer iD) {
       Comment contact = (Comment) this.sessionFactory.getCurrentSession().load(Comment.class, iD);
        if (null != contact) {
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

 //   public void correctBook(Integer iD, Book book) {
 //       Book contact = (Book) this.sessionFactory.getCurrentSession().load(Book.class, iD);
  //      if (null != contact) {
     //       contact.setName(book.getName());
      //      contact.setAbout(book.getAbout());
       //     contact.setGenre(book.getGenre());
        //    contact.setAuthor(book.getAuthor());
      //      contact.setYear(book.getYear());
    //        contact.setCount(book.getCount());
    //        contact.setRating(book.getRating());
   //         this.sessionFactory.getCurrentSession().update(contact);
  //      }
 //   }
}
