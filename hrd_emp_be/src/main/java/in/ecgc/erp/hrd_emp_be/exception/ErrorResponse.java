package in.ecgc.erp.hrd_emp_be.exception;

import java.util.List;

import lombok.Data;
/**
 *Error Response class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@Data
public class ErrorResponse 
{
	
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
 
    //General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;
 
    //Getter and setters
}