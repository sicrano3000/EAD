package com.ead.authuser.services;

import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;

import java.util.UUID;

public interface UserCourseService {

    UserCourseModel save(UserCourseModel convertToUserCourseModel);

    boolean existsByUserAndCourseId(UserModel userModel, UUID courseId);

}
