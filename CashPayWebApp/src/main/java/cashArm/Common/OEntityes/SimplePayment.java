package cashArm.Common.OEntityes;


import cashArm.Common.OEntityes.main.OContract;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 24.12.13
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
public interface SimplePayment {

    OContract getDog();
    String getTxId();
    Calendar getTxDate();
    Double getTxAmount();
    String getComment();

}
