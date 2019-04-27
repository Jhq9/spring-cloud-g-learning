package may.i.jhq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AlibabaNacosConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosConfigClientApplication.class, args);
	}

	@Slf4j
	@RestController
	@RefreshScope
	public static class TestController {

		@Value("${may.name}")
		private String name;

		@GetMapping("/test")
		public String hello() {
			return name;
		}
	}
}
