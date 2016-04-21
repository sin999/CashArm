package cashArm.onyma.OnymaPayments;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.12.13
 * Time: 8:22
 * To change this template use File | Settings | File Templates.
 */
public class PayParamParseException extends ParseException {
    public PayParamParseException(String s, int errorOffset) {
        super(s,errorOffset);
    }

}
