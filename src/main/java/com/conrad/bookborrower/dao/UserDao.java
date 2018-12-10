package com.conrad.bookborrower.dao;

import com.conrad.bookborrower.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends JpaRepository<User, Long>
{

}
