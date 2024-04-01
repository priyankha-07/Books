package com.intern.pentafox.books.booksservice.impl;
import com.intern.pentafox.books.booksentity.Books;
import com.intern.pentafox.books.booksservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper rowmapper =(rs, rowNum)-> new Books(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("quantity"),
            rs.getDouble("price"));
    @Override
    public List<Books> getallbooks() {
        var sql ="SELECT * FROM books";
        return jdbcTemplate.query(sql, rowmapper);

    }

    @Override
    public void createBooks(Books book) {
        var sql = "INSERT INTO books (id, name, quantity, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getId(), book.getName(), book.getQuantity(), book.getPrice());
    }


    @Override
    public void UpdateBooks(int id, Books book) {
    var sql = "update books set name=?, price=?, quantity=? where id=?";
    jdbcTemplate.update(sql , book.getName(),book.getPrice(),book.getQuantity(),id);
    }

    @Override
    public void DeleteBooks(int id) {
        var sql="delete  from books where id =?";
        jdbcTemplate.update(sql , id);

    }
}
