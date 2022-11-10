package boot.restful.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    // 이렇게 UserDaoService 선언 후, 생성자를 호출하는 게 객체 지향적으로 맞다고 했던가, DI 방식에서 맞다고 했던가 그랬다.
    private UserDaoService userDaoService;

    public UserController(UserDaoService service){
        this.userDaoService = service;
    }

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return userDaoService.findAll();
    }

    // GET /users/1 -> 전달 시 String 형태
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){

        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found" , id));
        }
        return user;

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //@RequestBody는 XML, JSON 형태와 같이 오브젝트 형태를 받기 위해 사용
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
