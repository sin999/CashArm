package cashArm.Common.OEntityes.Constants;

/**
 * Created by Admin on 04.07.14.
 */
public enum UTID {
    FL(19.0),
    UL(18.0),
    EXPEND(21.0);
    private double code;
    UTID(double code){
        this.code=code;
    }

    public double getCode() {
        return code;
    }

    public static UTID getByCode(Double code){
        UTID utid=FL;
        for (UTID curUtid: UTID.values()){
            if (utid!=null && curUtid.code==code){
                utid=curUtid;
            }
        }
        return utid;
    }
}
