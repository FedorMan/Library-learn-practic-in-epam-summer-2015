package com.springapp.mvc.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.*;


@Entity
@Table (name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue()
    private int iD;

    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private int year;
    @Column(name = "genre")
    private String genre;
    @Column(name = "about")
    private String about;
    @Column(name = "rating")
    private int rating;
    @Column(name = "count")
    private int count;

    public String getAbout() {
        return about;
    }
    @RequestMapping(value = "//", method = RequestMethod.GET)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRating() {

        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
