package cashArm.Common.OEntityes.ConstantsNew;

/**++
 * Created by Admin on 04.07.14.
 */
public enum UTID {
    FL(26.0),
    UL(25.0),
    EXPEND(33.0);
    private double code;
    UTID(double code){
        this.code=code;
    }

    public double getCode() {
        return code;
    }

    public static UTID getByCode(Double code){
        UTID utid=FL;
        for (UTID curUtid:UTID.values()){
            if (utid!=null && curUtid.code==code){
                utid=curUtid;
            }
        }
        return utid;
    }
}

//"Тип договора";"utid";"utid_kttk"
//        "ЮЛ";"18";"26"
//        "ФЛ";"19";"25"
//        "Расходный";"21";"33"
