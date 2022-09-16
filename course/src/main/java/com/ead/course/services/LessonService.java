package com.ead.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ead.course.models.LessonModel;

public interface LessonService {

	LessonModel save(LessonModel lessonModel);

	Optional<LessonModel> findLessonIntoModule(UUID lessonId, UUID moduleId);

	void delete(LessonModel lessonModel);

	List<LessonModel> findAllByCourse(UUID moduleId);

}
