package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 15.02.14
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public enum OResources {
    unknownSevice(0),
    blockOfNet(10943),//[ТТК] Блок сетей
    NAS(10944),//[ТТК] NAS
    WimaxConnection(10963),//[ТТК] Wimax Подключение
    JuniperPolicy(10983),//[ТТК] Политика Juniper
    broadbandConnection(10984),//[ТТК] ШПД Подключение
    fullSpeed(11003),//[ТТК] Без понижения скорости
    limitedSpeed(11004),//[ТТК] С понижением скорости
    building(11023),//[ТТК] Здание
    switchTTK(11024),//[ТТК] Коммутатор
    dinamicIP(11025),//[ТТК] Динамический IP адрес
    staticIP(11026),//[ТТК] Статический IP адрес
    blockOfStaticIP(11027),//[ТТК] Блок статических адресов
    translationTableBNumbers(11103),//[ТТК] Таблица трансляции Б-номеров
    phoneCode(11104),//[ТТК] Телефонный код
    phoneNumberSeria(11105),//[ТТК] Серия номеров
    ATS(11106),//[ТТК] АТС
    phoneNumber(11107),//[ТТК] Телефонный номер
    connectionIpAddr_subNet(11123),//[ТТК] Подключение ip-адрес/подсеть
    IPtraficGaitheringPoint(11124),//[ТТК] Точка сбора IP-трафика
    VoIPConnection(11143),//[ТТК] VoIP-подключение
    ISGConnection(11163),//[ТТК] Подключение (ISG)
    ISGService(11164),//[ТТК] Сервис ISG
    KTVConnection(11244),//[ТТК] KТВ-подключение
    employ(11245),//Сотрудник компании
    signaturesSet(11246),//Набор подписей
    accesToPersonalCabinet(11263),//[ТТК] Доступ в личный кабинет
    groupOfTrunck(11283),//[ТТК] Транковая группа
    bidirectionTrunck(11284),//Двунаправленный транк
    tranckType(11285),//[ТТК] Тип транка
    CiscoPolicy(11303),//[ТТК] Политика Cisco
    numbersDiapason(11304),//[ТТК] Дипазон нумерации
    VPNConnection(11305),//[ТТК] VPN-подключение
    dedicatedChanall(11306),//[ТТК] Выделенный канал
    opticFibers(11323),//[ТТК] Оптические волокна
    factoryResouces(11324),//[ТТК] Производственные ресурсы
    equipmentLeasing(11343),//[ТТК] Аренда оборудования
    pereodicService(11344),//Периодические услуги
    WimaxProfile(11383),//[ТТК]  Wimax Профиль
    portConnection(11403),//[ТТК] Подключение к порту
    portType(11404),//[ТТК] Тип порта
    informationMessage(11424);//Информационное сообщение
    private double id;
    OResources(int id){
        this.id=(double)id;
    }
    public double getId(){
        return id;
    }
    public String getName(){
        return name()+"("+id+")";
    }

    public static OResources getByCode(int code){
        OResources retValue=null;
        for(OResources resource: OResources.values()){
            if(resource.getId()==code){
                retValue=resource;
            }
        }
        return retValue;
    }
    public static OResources getByCode(Double code){
        return getByCode((code==null?0:code.intValue()));
    }
}
