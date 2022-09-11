package com.ead.course.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ead.course.repositories.LessionRepository;
import com.ead.course.services.LessionService;

@Service
public class LessionServiceImpl implements LessionService {
	
	@Autowired
	private LessionRepository lessionRepository;

}
