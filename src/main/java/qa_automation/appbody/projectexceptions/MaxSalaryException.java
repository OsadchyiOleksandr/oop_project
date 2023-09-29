package qa_automation.appbody.projectexceptions;

import qa_automation.appbody.Support;

public class MaxSalaryException extends Exception {

    private String message = Support.DEFAULT;
    public MaxSalaryException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
