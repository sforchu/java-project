package com.safaew.demo_app.controller;

import com.safaew.demo_app.FakeDb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    //create book
    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody Book book){
        FakeDb.fakeDB.put(book.getIsbn(), book);
        return new ResponseEntity<>(HttpStatus.CREATED); //201

    }

    //retrieve all book
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = new ArrayList<>(FakeDb.fakeDB.values());
        return new ResponseEntity<>(books, HttpStatus.OK); //200
    }

    //retrieve a book using pathvariable
    //http://localhost:8080/books/123456
    @GetMapping("/{isbn}")
    public ResponseEntity <Book> getABook(@PathVariable("isbn") String isbn){
        Book book = FakeDb.fakeDB.get(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK); //200
    }

    //retrieve a book using queryparam
    //http://localhost:8080/books/q?id=12345
    @GetMapping("/q")
    public ResponseEntity <Book> getABook2(@RequestParam("id") String isbn){
        Book book = FakeDb.fakeDB.get(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK); //200
    }

    //update book
    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateABook(@PathVariable("isbn") String isbn, @RequestBody Book book){
//        Book oldbook = FakeDb.fakeDB.put(isbn);
//        oldbook = book;
        FakeDb.fakeDB.put(isbn, book);
        return new ResponseEntity<>(book, HttpStatus.OK); //200
    }

    //delete book
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Book> deleteABook(@PathVariable("isbn") String isbn){
//        Book oldbook = FakeDb.fakeDB.get(isbn);
//        oldbook = book;
        FakeDb.fakeDB.remove(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }
}
