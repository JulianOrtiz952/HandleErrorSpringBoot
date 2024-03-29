package com.handleerrorspringboot.handleerror.repository;

import com.handleerrorspringboot.handleerror.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmail(String email);

}
