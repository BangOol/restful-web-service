package boot.restful.restfulwebservice.helloworld;

// lombok

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldBean{
    private String message;
    // 모든 인자에 대한 생성자 생성 : AllArgsConstructor
    // getter, setter, toString : Data
    // undo
//    public HelloWorldBean(String message){
//        this.message = message;
//    }
}
