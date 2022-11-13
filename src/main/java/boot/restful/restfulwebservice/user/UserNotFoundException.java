package boot.restful.restfulwebservice.user;
// HTTP Status
// 200 ->  OK
// 4xx -> Client
// 5xx -> server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// resource 문제일 경우.

// 이 오류는 5xx 오류가 아닌 4xx로 처리된다.
// 이렇게 상황에 따라 오류에 대한 HTTP status 처리를 조정할 수 있다.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);

    }


}
