package com.conrad.bookborrower.service;

import com.conrad.bookborrower.dao.UserDao;
import com.conrad.bookborrower.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserDao userDao;

    /* add book */
    public User save(User book)
    {
        return userDao.save(book);
    }

    /* search all books */
    public List<User> findAll()
    {
        return userDao.findAll();
    }

    /* get book by id */
    public User findById(Long bookId)
    {
        return userDao.getOne(bookId);
    }

    /* delete a book */
    public void delete(User book)
    {
        userDao.delete(book);
    }
}
