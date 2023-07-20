package com.ead.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ead.course.models.CourseModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<CourseModel, UUID>, JpaSpecificationExecutor<CourseModel> {

    @Query(value = "SELECT CASE WHEN COUNT(tcu) > 0 THEN true ELSE false END FROM TB_COURSES_USERS tcu WHERE tcu.course_id = :courseId and tcu.userId = :userId", nativeQuery = true)
    boolean existsByCourseAndUser(@Param("courseId") UUID courseId, @Param("userId") UUID userId);

    @Modifying
    @Query(value = "INSERT INTO TB_COURSES_USERS VALUES (:courseId, :userId)", nativeQuery = true)
    void saveSubscriptionUserInCourse(@Param("courseId") UUID courseId, @Param("userId") UUID userId);

}
