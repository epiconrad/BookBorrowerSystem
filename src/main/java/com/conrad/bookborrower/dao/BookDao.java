package com.conrad.bookborrower.dao;

import com.conrad.bookborrower.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long>
{

}
