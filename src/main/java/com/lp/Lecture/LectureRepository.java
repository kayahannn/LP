package com.lp.Lecture;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    Lecture getById(Long id);
    @Query(value = "SELECT lectures.id, lectures.name, modules.id AS module_id, modules.name AS module_name, courses.id AS course_id, courses.name AS course_name, users.user_id AS user_id, users.name AS user_name FROM lectures " +
            "JOIN modules ON lectures.module_id = modules.id JOIN courses ON modules.course_id = courses.id JOIN users ON courses.id = users.course_id WHERE users.user_id = :id", nativeQuery = true)
    Iterable<Lecture> findByUserId(@Param("id") Long id);
//    @Query(value = "SELECT * FROM shoes WHERE shoes.brand LIKE :brand", nativeQuery = true)
//    Iterable<Shoes> findByBrand(@Param("brand") String brand);
}
