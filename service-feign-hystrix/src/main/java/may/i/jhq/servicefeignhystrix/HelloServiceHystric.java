package may.i.jhq.servicefeignhystrix;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystric implements HelloService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }
}
