package com.conrad.bookborrower.service;

import com.conrad.bookborrower.dao.BookDao;
import com.conrad.bookborrower.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService
{
    @Autowired
    BookDao bookDao;

    /* add book */
    public Book save(Book book)
    {
        return bookDao.save(book);
    }

    /* search all books */
    public List<Book> findAll()
    {
        return bookDao.findAll();
    }

    /* get book by id */
    public Book findById(Long bookId)
    {
        return bookDao.getOne(bookId);
    }

    /* delete a book */
    public void delete(Book book)
    {
        bookDao.delete(book);
    }
}
