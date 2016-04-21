package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
public enum CreditShem {
    UNLIMITED_CREDIT(47.0),
    PREPAY(48.0),
    PREPAY_BLOCKING(50.0);
    private Double id;
    CreditShem(Double id){
       this.id=id;
    }

    public Double getId() {
        return id;
    }
}
