package com.lp.Lecture;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    Lecture getById(Long id);
//    @Query(value = "SELECT * FROM shoes WHERE shoes.brand LIKE :brand", nativeQuery = true)
//    Iterable<Shoes> findByBrand(@Param("brand") String brand);
}
