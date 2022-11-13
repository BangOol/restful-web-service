package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// web service에서 사용할 수 있도록 RestController annotation
// ControllerAdvice : controller 실행 시 ControllerAdvice를 가진 bean이 실행되어 예외 발생 시 실행됨.
// 일반화된 오류 시 사용함.
@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // 일반적인 오류 발생 시
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
        // 예외 발생 확인 : Exception
        // 예외 발생이 어느 web에서 발생하였는가 : request
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 유저를 발생하지 못했을 때
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest webRequest){
        // 예외 발생 확인 : Exception
        // 예외 발생이 어느 web에서 발생하였는가 : request
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}
