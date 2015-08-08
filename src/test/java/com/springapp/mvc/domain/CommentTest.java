package com.springapp.mvc.domain;

import junit.framework.TestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommentTest extends TestCase {

    public void testGetiDBook() throws Exception {
        Comment mockedComment=mock(Comment.class);
        when(mockedComment.getiDBook()).thenReturn(1);
        assertEquals(mockedComment.getiDBook(),1);
    }

    public void testSetiDBook() throws Exception {
        Comment mockedComment=mock(Comment.class);
        mockedComment.setiDBook(1);
        verify(mockedComment).setiDBook(1);
    }

    public void testGetText() throws Exception {
        Comment mockedComment=mock(Comment.class);
        when(mockedComment.getText()).thenReturn("text");
        assertEquals(mockedComment.getText(),"text");
    }

    public void testSetText() throws Exception {
        Comment mockedComment=mock(Comment.class);
        mockedComment.setText("text");
        verify(mockedComment).setText("text");
    }

    public void testGetAuthor() throws Exception {
        Comment mockedComment=mock(Comment.class);
        when(mockedComment.getAuthor()).thenReturn("author");
        assertEquals(mockedComment.getAuthor(),"author");
    }

    public void testSetAuthor() throws Exception {
        Comment mockedComment=mock(Comment.class);
        mockedComment.setAuthor("author");
        verify(mockedComment).setAuthor("author");
    }

    public void testGetiD() throws Exception {
        Comment mockedComment=mock(Comment.class);
        when(mockedComment.getiD()).thenReturn(1);
        assertEquals(mockedComment.getiD(),1);

    }

    public void testSetiD() throws Exception {
        Comment mockedComment=mock(Comment.class);
        mockedComment.setiD(1);
        verify(mockedComment).setiD(1);
    }
}