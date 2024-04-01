package com.intern.pentafox.books.booksservice;

import com.intern.pentafox.books.booksentity.Books;

import java.util.List;

public interface BookService {

    List<Books> getallbooks();

    void createBooks (Books book);

    void UpdateBooks (int id , Books book);

    void DeleteBooks(int id);

}
