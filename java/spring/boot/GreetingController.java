package SpringBootSample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	
	@PostMapping("/hello")
	public String postProcessor(@RequestBody Greeting greeting) {
		return template.formatted(greeting.name());
	}

	@GetMapping("/hi/{name}")
	public String getProcessor(@PathVariable String name) {
		return template.formatted(name);
	}
}
