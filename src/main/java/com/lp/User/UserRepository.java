package com.lp.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    public User getUserByName(@Param("name") String name);
    public User getUserByEmail(String email);
}
