package com.yang.projectmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yang.projectmanager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
}