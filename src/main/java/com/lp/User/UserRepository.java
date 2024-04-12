package com.lp.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByEmail(String email);

    User getUserByName(@Param("name") String name);
}
