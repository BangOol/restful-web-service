package boot.restful.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    // @NoArgsConstructor는 디폴트 생성자를 만들어준다.
    private Integer id;
    private String name;
    private Date joinDate;
}
