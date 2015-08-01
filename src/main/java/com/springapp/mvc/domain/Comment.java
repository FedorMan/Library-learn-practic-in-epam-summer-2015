package com.springapp.mvc.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue()
    private int iD;

    public int getiDBook() {
        return iDBook;
    }

    public void setiDBook(int iDBook) {
        this.iDBook = iDBook;
    }

    @Column(name = "idBook")
    private int iDBook;
    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getiD() {

        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
}
