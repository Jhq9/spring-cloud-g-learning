package may.i.jhq.configjdbcclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class ConfigJdbcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigJdbcClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/foo")
    public String hi(){
        return foo;
    }

}
