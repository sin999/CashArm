package cashArm.Common.Services;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.12.13
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
public class NoContractFoundException extends Exception{
    private String message="";
    public NoContractFoundException(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
