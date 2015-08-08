package com.springapp.mvc.controller;


import com.springapp.mvc.domain.Comment;

import com.springapp.mvc.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 контроллер комментариев
 */
@Controller
public class CommentController {

    private CommentRepository commentRepository;
    public static int numberBook;

    @Autowired
    public CommentController(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    /**
     метод получает идентификатор книги, затем получает из бд список комментариев, удаляет из него не нужные комментарии и отправляет на страницу
     */
    @RequestMapping(value = "viewComments/{id}", method = RequestMethod.GET)
    public String getComments(Model model, @PathVariable Integer id) {
        numberBook = id;
        List<Comment> comments = this.commentRepository.listAll();
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getiDBook() == numberBook) {
                continue;
            }
            comments.remove(i);
            i--;
        }

        model.addAttribute("comments", comments);

        return "viewComments";
    }
    /**
     метод получает из бд список комментариев, удаляет из него не нужные комментарии и отправляет на страницу
     */
    @RequestMapping(value = "postAddComment", method = RequestMethod.GET)
    public String getPostAddComments(Model model) {
        List<Comment> comments = this.commentRepository.listAll();
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getiDBook() == numberBook) {
                continue;
            }
            comments.remove(i);
            i--;
        }
        model.addAttribute("comments", comments);

        return "postAddComment";
    }

    /**
     метод посылает объект комментария в форму
     */
    @RequestMapping(value = "addComment", method = RequestMethod.GET)
    public String addComment(Model model) {
        model.addAttribute("comment", new Comment());

        return "addComment";
    }

    /**
    метод добавляет в объект комментария указатель на книгу и отправляет объект в репозиторий для записи в бд
     */
    @RequestMapping(value = "addComment", method = RequestMethod.POST)

    public String addComment(@ModelAttribute("comment") Comment comment) {
        comment.setiDBook(numberBook);
        this.commentRepository.addComment(comment);
        return "redirect:/postAddComment";
    }

    /**
     метод получает идентификатор комментария и отправляет его в репозиторий для дальнейшего удаления
     */
    @RequestMapping(value = "deleteComment/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable Integer id) {
        this.commentRepository.removeComment(id);

        return "redirect:/postAddComment";
    }


    //  @RequestMapping(value = "correctComment/{id}", method = RequestMethod.GET)
//    public String correctBook(Model model,@PathVariable Integer id) {
    // d=id;
    //  model.addAttribute("comment", new Comment());
    //   return "correctComment";
    // }
    // @RequestMapping(value = "correctComment/{id}", method = RequestMethod.POST)
    //  public String correctComment(@ModelAttribute("comment") Comment comment) {
    //   this.commentRepository.correctComment(p,comment);
    //     return "redirect:/";
    //   }
}
