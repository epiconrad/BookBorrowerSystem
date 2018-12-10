package com.conrad.bookborrower.controller;

import com.conrad.bookborrower.model.Book;
import com.conrad.bookborrower.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/library")
public class BookController
{
    @Autowired
    private BookService bookService;

    /*@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("userForm",new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,BindingResult bindingResult, Model model)
    {
        userValidator.validate(userForm,bindingResult);
        if (bindingResult.hasErrors())
        {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/books";
    }

     @GetMapping("/login")
    public String login(Model model, String error, String logout)
    {
        if(error!=null)
        {
            model.addAttribute("error","You have entered wrong username or password.");
        }
        if(logout!=null)
        {
            model.addAttribute("error","You have been logged out successfully.");
        }

        return "login";
    }
    */
    @CrossOrigin
    @PostMapping("/books")
    public Book addBook(@Valid @RequestBody Book book)
    {
        return bookService.save(book);
    }

    @CrossOrigin
    @GetMapping(value = {"/","/books"})
    public List<Book> findAllBooks()
    {
        return bookService.findAll();
    }

    @CrossOrigin
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable(value="id") Long bookId)
    {
        Book book = bookService.findById(bookId);

        if(book==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }

    @CrossOrigin
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody Book bookDetails)
    {
        Book book = bookService.findById(bookId);

        if(book==null)
        {
            return ResponseEntity.notFound().build();
        }
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setCategory(bookDetails.getCategory());
        book.setYear(bookDetails.getYear());

        Book updateBook = bookService.save(book);
        return ResponseEntity.ok().body(updateBook);
    }

    @CrossOrigin
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value="id") String id)
    {   Long bookId = Long.valueOf(id);
        Book book = bookService.findById(bookId);

        if(book==null)
        {
            return ResponseEntity.notFound().build();
        }

        bookService.delete(book);
        return ResponseEntity.ok().build();
    }
}
