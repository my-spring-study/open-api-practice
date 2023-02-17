package study.openapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaverApi {

	@GetMapping("/api/vi")
	public String api() {
		return "";
	}
}
