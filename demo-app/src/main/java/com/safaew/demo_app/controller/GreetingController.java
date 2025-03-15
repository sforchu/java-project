package com.safaew.demo_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@Controller // used alongside @ResponseBody https://stackoverflow.com/questions/72176884/springboot-controller-and-restcontroller-annotations-when-to-use-and-what-is-t
public class GreetingController {

//    @RequestMapping(value = "/helloapp", method = RequestMethod.GET)

    @GetMapping("/hello")
    public String hello(){

        return "Welcome to Springboot!!";

    }

//    this is for html which is front-end. For back-enders we deal with json
//    @RequestMapping(value = "/helloapp2", method = RequestMethod.GET)
//    public String hello2(Model model){
//        model.addAttribute("Hello");
//
//        return "hello.html";
//
//    }


//    @RequestMapping(value = "/book", method = RequestMethod.GET)

    @GetMapping("/book")
    public Book getBook(){
        Book book = new Book();
        book.setName("My first book");
        book.setIsbn("246");

        return book;

    }



    @GetMapping("/add-book")
    public Book addBook(@RequestParam String isbn, @RequestParam (name = "bn", required = false)String bookName){


        Book book = new Book();
        book.setName(bookName);
        book.setIsbn(isbn);

        return book;

    }


}
