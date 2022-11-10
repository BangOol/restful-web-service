package boot.restful.restfulwebservice.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // URL : /hello-world (endpoint)
    // @RequestMapping(method = RequestMethod.GET, path = "hello-world") -> getMapping or postMapping 등
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "hello-world";
    }

    // alt + enter
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello-world");
    }

    // overloading으로 인해 오류 사라짐.
    // 만약 다른 값을 path variable로 사용할 것이라면 @PathVariable(value = "name")
    @GetMapping(path = "hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }
}
