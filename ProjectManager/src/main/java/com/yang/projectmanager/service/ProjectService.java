package com.yang.projectmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yang.projectmanager.models.Project;
import com.yang.projectmanager.models.User;
import com.yang.projectmanager.repository.ProjectRepository;

@Service
public class ProjectService {
		private final ProjectRepository projectRepository;
		
		public ProjectService(ProjectRepository projectRepository) {
			this.projectRepository = projectRepository;
		}
		public List<Project> allProjects(){
			return projectRepository.findAll();
		}
		
		public Project updateProject(Project project) {
			return projectRepository.save(project);
		}
		
		public List<Project> getAssignedProjects(User user){
			return projectRepository.findAllByUsers(user);
		}
		
		public List<Project> getUnassignedProjects(User user){
			return projectRepository.findByUsersNotContains(user);
		}
		
		public Project addProject(Project project) {
			return projectRepository.save(project);
		}
		
		public void deleteProject(Project project) {
			projectRepository.delete(project);
		}
		
		public Project findById(Long id) {
			Optional<Project> optionalProject = projectRepository.findById(id);
			if(optionalProject.isPresent()) {
				return optionalProject.get();
			}else {
				return null;
			}
		}
}		
