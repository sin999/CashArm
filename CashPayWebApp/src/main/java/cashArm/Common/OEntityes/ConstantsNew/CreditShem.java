package cashArm.Common.OEntityes.ConstantsNew;

/**++
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
public enum CreditShem {
    UNLIMITED_CREDIT(56.0),
    PREPAY(66.0),
    PREPAY_BLOCKING(65.0);
    private Double id;
    CreditShem(Double id){
       this.id=id;
    }

    public Double getId() {
        return id;
    }
}
//          "Наименование";                 "csid"; "csid_kttk"
//        "Кредит 20 дней на оплату";       "49";   "55"
//        "Неограниченный кредит";          "47";   "56"
//        "Предоплата (280 руб. минимум)";  "52";   "57"
//        "Предоплата (350 руб. минимум)";  "53";   "58"
//        "Предоплата (400 руб. минимум)";  "57";   "59"
//        "Предоплата (450 руб. минимум)";  "54";   "60"
//        "Предоплата (500 руб. минимум)";  "58";   "61"
//        "Предоплата (550 руб. минимум)";  "55";   "62"
//        "Предоплата (600 руб. минимум)";  "59";   "63"
//        "Предоплата (750 руб. минимум)";  "56";   "64"
//        "Предоплата(блокировка)";         "50";   "65"
//        "Предоплата(100%)";               "48";   "66"