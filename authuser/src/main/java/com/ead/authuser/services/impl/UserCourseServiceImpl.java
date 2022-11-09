package com.ead.authuser.services.impl;

import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;
import org.springframework.stereotype.Service;

import com.ead.authuser.repositories.UserCourseRepository;
import com.ead.authuser.services.UserCourseService;

import java.util.UUID;

@Service
public class UserCourseServiceImpl implements UserCourseService {
	
	final
	UserCourseRepository userCourseRepository;

	public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
		this.userCourseRepository = userCourseRepository;
	}

    @Override
    public UserCourseModel save(UserCourseModel convertToUserCourseModel) {
        return userCourseRepository.save(convertToUserCourseModel);
    }

    @Override
    public boolean existsByUserAndCourseId(UserModel userModel, UUID courseId) {
        return userCourseRepository.existsByUserAndCourseId(userModel, courseId);
    }
}
