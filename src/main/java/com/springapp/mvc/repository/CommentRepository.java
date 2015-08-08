package com.springapp.mvc.repository;


import com.springapp.mvc.domain.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 репозиторий комментария (ведет работу с бд)
 */
@Repository
@Transactional
public class CommentRepository {
    @Autowired
    private SessionFactory sessionFactory;
    /**
     метод сохраняет комментарий в бд
     */
    public void addComment(Comment comment) {
        this.sessionFactory.getCurrentSession().save(comment);
    }
    /**
     метод получает список комментариев из бд
     */
    public List<Comment> listAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Comment").list();
    }
    /**
     метод удаляет комментарий из бд по его уникальному идентификатору
     */
    public void removeComment(Integer iD) {
       Comment contact = (Comment) this.sessionFactory.getCurrentSession().load(Comment.class, iD);
        if (null != contact) {
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

 //   public void correctComment(Integer iD, Comment comment) {
 //       Comment contact = (Comment) this.sessionFactory.getCurrentSession().load(Comment.class, iD);
  //      if (null != contact) {

   //         this.sessionFactory.getCurrentSession().update(contact);
  //      }
 //   }
}
