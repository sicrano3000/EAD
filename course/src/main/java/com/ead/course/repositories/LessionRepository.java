package com.ead.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ead.course.models.LessionModel;

public interface LessionRepository extends JpaRepository<LessionModel, UUID> {

}
