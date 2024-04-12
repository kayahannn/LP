package com.lp.Lecture;

import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    Lecture getById(Long id);
}
