package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public enum  Groups {
    ROOT(1.0),
    TTK(29851.0),
    TTKR(29852.0),
    ULYANOVSK(30670.0),
    SAMARA_TTK(30712.0),
    ULYANOVSK_UL(31091.0),
    ULYANOVSK_FL(31092.0),
    ULYANOVSK_FL_LEFT_RIVERSIDE(31093.0),
    SAMARA(31110.0),
    PENZA(31111.0),
    ULYANOVSK_FL_RIGHT_RIVERSIDE(31153.0),
    UFA(31310.0),
    SAMARA_OPERATORS(31370.0),
    ULYANOVSK_KK(31412.0),
    SARANSK(31451.0),
    STERLITAMAK(31452.0),
    BASHKIRTOSTAN(31459.0),
    KTTK(31555.0),
    RTK_SAMARA(31556.0),
    RTK_PENZA(31557.0),
    SAMARA_TTK_VOIP(31558.0),
    KINEL(31624.0),
    SYZRAN(31625.0),
    _(31783.0),
    __(31784.0),
    UFA_OPERATORS(32023.0);
    private Double id;
    Groups(Double id){
        this.id=id;
    }
    public Double getId(){
        return id;
    }
}
