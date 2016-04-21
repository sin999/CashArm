package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 15.02.14
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public enum ODogAttributes {
    phone(24),
    FIO(250),
    contactPhoneStac(260),
    contactPhoneMob(261),
    registrationAddress(262),
    birstDayDate(263),
    familia(267),
    name(268),
    otchestvo(269),
    infoSource(270),
    manager(271),
    remark(272),
    email(276),
    factAddress(281),
    passportData(291),
    MGMN_TTK_DogNumber(295),
    MGMN_TTK_DogovorDate(296),
    posteAddress(298),
    paperDogNumber(306),
    idFromOldBilling(307),
    vip(308),
    smsReclama(310),
    smsBalance(311),
    smsInformation(312),
    smsNumber(313),
    uploadDate(316),
    BC(317),
    group(320),
    secretWord(330),
    commonGroupFL(331),
    comment(334),
    bonusReturn(374),
    index(253),
    oblast(254),
    city(255),
    street(256),
    house(257),
    flat(259),
    organisationNameFull(278),
    organisationNameShirt(279),
    inn(280),
    kpp(283),
    addressUr(289),
    codeESUP(323);

    private double id;
    ODogAttributes(int id){
     this.id=(double)id;
    }
    public double getId(){
        return id;
    }


}
