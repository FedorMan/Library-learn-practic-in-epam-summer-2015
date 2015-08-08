package com.springapp.mvc.domain;

import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class BookTest extends TestCase {

    public void testGetAbout() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getAbout()).thenReturn("about");
        assertEquals(mockedBook.getAbout(),"about");
    }

    public void testGetCount() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getCount()).thenReturn(100);
        assertEquals(mockedBook.getCount(),100);
    }

    public void testSetCount() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setCount(1);
        verify(mockedBook).setCount(1);
    }

    public void testGetRating() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getRating()).thenReturn(10);
        assertEquals(mockedBook.getRating(),10);
    }

    public void testSetRating() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setRating(1);
        verify(mockedBook).setRating(1);
    }

    public void testGetYear() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getYear()).thenReturn(1900);
        assertEquals(mockedBook.getYear(),1900);
    }

    public void testSetYear() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setYear(1);
        verify(mockedBook).setYear(1);
    }

    public void testGetAuthor() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getAuthor()).thenReturn("author");
        assertEquals(mockedBook.getAuthor(),"author");
    }

    public void testSetAuthor() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setAuthor("author");
        verify(mockedBook).setAuthor("author");
    }

    public void testSetAbout() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setAbout("about");
        verify(mockedBook).setAbout("about");
    }

    public void testGetiD() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getiD()).thenReturn(1);
        assertEquals(mockedBook.getiD(),1);
    }

    public void testSetiD() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setiD(1);
        verify(mockedBook).setiD(1);
    }

    public void testGetName() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getName()).thenReturn("name");
        assertEquals(mockedBook.getName(),"name");
    }

    public void testSetName() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setName("name");
        verify(mockedBook).setName("name");
    }

    public void testGetGenre() throws Exception {
        Book mockedBook=mock(Book.class);
        when(mockedBook.getGenre()).thenReturn("genre");
        assertEquals(mockedBook.getGenre(),"genre");
    }

    public void testSetGenre() throws Exception {
        Book mockedBook=mock(Book.class);
        mockedBook.setGenre("genre");
        verify(mockedBook).setGenre("genre");
    }
}