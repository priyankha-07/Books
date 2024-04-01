package com.intern.pentafox.books.bookscontroller;

import com.intern.pentafox.books.booksentity.Books;
import com.intern.pentafox.books.booksservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService service;

   @GetMapping("fetchallbooks")
   List<Books> getlistofbooks(){
        return service.getallbooks();
    }
   @PostMapping("insertbook")
   String insertbook(@RequestBody Books book){
        service.createBooks(book);
        return "inserted successfully";
    }
    @PutMapping("updatebook/{id}")
    String update (@PathVariable int id , @RequestBody Books book){
       service.UpdateBooks(id ,book);
       return "Successfully updated";
    }
    @DeleteMapping("deletebook/{id}")

     String delete(@PathVariable int id){
       service.DeleteBooks(id);
       return"Successfully deleted";

    }
}
