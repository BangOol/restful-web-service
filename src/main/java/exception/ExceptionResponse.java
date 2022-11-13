package exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    // 예외 처리를 위한 객체
    private Date timeStamp;
    private String message;
    private String details;
}
