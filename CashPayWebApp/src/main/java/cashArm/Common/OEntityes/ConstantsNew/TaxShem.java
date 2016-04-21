package cashArm.Common.OEntityes.ConstantsNew;

/**++
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public enum TaxShem {
    INCLUDE_NDS(1.0),
    EXCLUDE_NDS(6.0);
    private Double id;
    TaxShem(Double id){
       this.id=id;
    }
    public Double getId(){
        return id;
    }
}
//"Наименование";"tsid";"tsid_kttk"
//        "НДС сверху";"42";"1"
//        "НДС вкл. в цену";"43";"6"