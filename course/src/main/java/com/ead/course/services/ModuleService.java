package com.ead.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ead.course.models.ModuleModel;

public interface ModuleService {
	
	void delete(ModuleModel moduleModel);

	ModuleModel save(ModuleModel moduleModel);

	Optional<ModuleModel> findModuleIntoCourse(UUID moduleId, UUID courseId);

	List<ModuleModel> findAllByCourse(UUID courseId);

	Optional<ModuleModel> findById(UUID moduleId);

}
