package com.yang.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.projectmanager.models.Task;
import com.yang.projectmanager.repository.TaskRepository;

@Service
public class TaskService {
	 @Autowired
	    private TaskRepository taskRepository;

	    // ------------------ Retrieve All ----------------- //
	    public List<Task> allTasks() {
	        return taskRepository.findAll();
	    }

	    // ------------------- Create One ------------------ //
	    public Task createTask(Task t) {
	        return taskRepository.save(t);
	    }
}
