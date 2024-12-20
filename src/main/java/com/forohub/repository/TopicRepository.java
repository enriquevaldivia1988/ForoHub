package com.forohub.repository;

import com.forohub.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTitleAndMessage(String title, String message);

    @Query("SELECT t FROM Topic t WHERE t.course.name = :courseName AND YEAR(t.createdAt) = :year")
    Page<Topic> findByCourseNameAndYear(@Param("courseName") String courseName, @Param("year") int year, Pageable pageable);
}
