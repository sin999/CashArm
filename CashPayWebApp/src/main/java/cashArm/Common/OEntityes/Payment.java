package cashArm.Common.OEntityes;


import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
public class Payment   implements Serializable {
//    <documentation>Запрос. внесение платежа
//    pdogid - id договора
//    pamount - сумма платежа
//    pbdate - дата зачисленя денег на л/с
//    pmdate - дата конвертации
//    pidate - дата поступления денег на р/с
//    ppaydoc - номер платежного поручения (п/п)
//    pppdate - дата платежного поручения (п/п)
//    premark - комментарий
//    pcurrid - валюта платежа
//    pppid - банковский счет для платежа
//    pbilldoc - привязка к документу
//    pconvcurr - валюта оплаты л/с
//    pactiv_date - дата активации платежа (если надо зачесть платеж позже)
//    pbcid - класс услуг
//    pbill - л/с или субсчет договора (позволяет добавлять платежи на субсчет)
//    puse_pay_prior - исползовать автоматическое разнесение платежа по классам услуг
//    p_bill_sum - список "номер счета - сумма - дата" для привязки платежа к счету, сумма указывается в валюте лс
//    p_ignore_bill_err - игнорировать ошибку привязки платежа к счету
//    p_load_id - идентификатор загрузки</documentation>

    Double                  pdogid;
    Double                  pamount;
    Calendar                pbdate;
    Calendar                pmdate;
    Calendar                pidate;
    String                  ppaydoc;
    Calendar                pppdate;
    String                  premark;
    Double                  pcurrid;
    Double                  pppid;
    String                  pbilldoc;
    Double                  pconvcurr;
    Calendar                pactiv_date;
    Double                  pbcid;
    Double                  pbill;
    Double                  puse_pay_prior;
//    T_o_mdb_tt_pay_bill_sum_row[] p_bill_sum;
    Double                  p_ignore_bill_err;
    String                  p_load_id;
}
