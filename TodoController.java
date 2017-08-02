

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

	 @Autowired
	 public TodoRepository todoRepository;
	 
	 @RequestMapping("/create")
	 public Map<String, Object> create(Todo todo) {
	  todo = todoRepository.save(todo);
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "Booking created successfully");
	  dataMap.put("status", "1");
	  dataMap.put("booking", todo);
	     return dataMap;
	 }
	 
	@RequestMapping("/all")
	 public List<Todo> readAll() {
	  return todoRepository.findAll();
	}
}