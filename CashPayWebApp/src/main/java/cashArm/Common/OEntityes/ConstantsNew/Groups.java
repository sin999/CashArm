package cashArm.Common.OEntityes.ConstantsNew;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public enum  Groups {
    ROOT(1.0),
    TTK(18290.0),
    TTKR(18290.0),
    ULYANOVSK(25893.0),
    SAMARA_TTK(25871.0),
    ULYANOVSK_UL(25893.0),
    ULYANOVSK_FL(25893.0),
    ULYANOVSK_FL_LEFT_RIVERSIDE(31093.0),
    SAMARA(18870.0),
    PENZA(25923.0),
    ULYANOVSK_FL_RIGHT_RIVERSIDE(31153.0),
    UFA(25913.0),
    SAMARA_OPERATORS(25924.0),
    ULYANOVSK_KK(25921.0),
    SARANSK(25917.0),
    STERLITAMAK(25912.0),
    BASHKIRTOSTAN(25911.0),
    KTTK(25951.0),
    RTK_SAMARA(25953.0),
    RTK_PENZA(25952.0),
    SAMARA_TTK_VOIP(25954.0),
    KINEL(25922.0),
    SYZRAN(25928.0),
    _(25927.0),
    __(25925.0),
    UFA_OPERATORS(25915.0);
    private Double id;
    Groups(Double id){
        this.id=id;
    }
    public Double getId(){
        return id;
    }
}
/*
                    Группа;   Название группы;      Группа КТТК
                    1         ;root;                      1
                    29851     ;TTK;                   18290
                    29852     ;ttkr;                  18290
                    31459     ;Башкортостан;          25911
                    31624     ;Кинель;                25922
                    32562     ;Ковылкино;             25918
                    31555     ;КТТК;                  25951
                    31111     ;Пенза;                 25923
                    31557     ;РТК Пенза;             25952
                    31556     ;РТК Самара;            25953
                    32561     ;Рузаевка;              25919
                    31110     ;Самара;                18870
                    31370     ;Самара - Операторы;    25924
                    30712     ;Самара ТТК;            25871
                    31784     ;Самара, Магистраль;    25925
                    31558     ;Самара-ТТК VoIP;       25954
                    31451     ;Саранск;               25917
                    31452     ;Стерлитамак;           25912
                    31625     ;Сызрань;               25928
                    30670     ;Ульяновск;             25893
                    32579     ;Ульяновск ADSL;        25926
                    31412     ;Ульяновск-КК;          25921
                    32378     ;Ульяновск-Операторы;   25920
                    31092     ;Ульяновск-ФЛ;          25893
                    31091     ;Ульяновск-ЮЛ;          25893
                    31310     ;Уфа;                   25913
                    32782     ;Уфа - Магистраль;      25914
                    32023     ;Уфа - Операторы;       25915
                    31783     ;Чапаевск;              25927
                    33577     ;Чишмы;                 25916
        */