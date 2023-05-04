package com.daikichi.path;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/daikichi")
public class DaikichiController {
	
	
	@RequestMapping("/{course}/{module}")
    public String showLesson(@PathVariable("course") String course, @PathVariable("module") String module){
    	return "Congratulations! You will soon " + course + "to " + module + " !";
    }
	
	@RequestMapping("/lotto/{id}")
	public String lotto(@PathVariable("id") int id) {
		if (id % 2 ==0 ) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		
	}
}
