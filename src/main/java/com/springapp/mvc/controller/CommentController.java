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

@Controller
public class CommentController {

    private CommentRepository commentRepository;
    //   public static int p;

    @Autowired
    public CommentController(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    @RequestMapping(value = "viewComments", method = RequestMethod.GET)
    public String getComments(Model model) {
        List<Comment> comments = this.commentRepository.listAll();

        model.addAttribute("comments", comments);

        return "viewComments";
    }

    @RequestMapping(value = "addComment", method = RequestMethod.GET)

    public String addComment(Model model) {
        model.addAttribute("comment", new Comment());

        return "addComment";
    }

    @RequestMapping(value = "addComment", method = RequestMethod.POST)

     public String addComment(@ModelAttribute("comment") Comment comment) {
      this.commentRepository.addComment(comment);
       return "redirect:/viewComments";
     }

     @RequestMapping(value = "deleteComment/{id}", method = RequestMethod.GET)
     public String deleteComment(@PathVariable Integer id) {
     this.commentRepository.removeComment(id);

      return "redirect:/viewComments";
    }


    //  @RequestMapping(value = "correctBook/{id}", method = RequestMethod.GET)
//    public String correctBook(Model model,@PathVariable Integer id) {
    // p=id;
    //  model.addAttribute("book", new Book());
    //   return "correctBook";
    // }
    // @RequestMapping(value = "correctBook/{id}", method = RequestMethod.POST)
    //  public String correctBook(@ModelAttribute("book") Book book) {
    //   this.bookRepository.correctBook(p,book);
    //     return "redirect:/";
    //   }
}
