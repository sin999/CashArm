package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public enum TaxShem {
    INCLUDE_NDS(42.0),
    EXCLUDE_NDS(43.0);
    private Double id;
    TaxShem(Double id){
       this.id=id;
    }
    public Double getId(){
        return id;
    }
}
