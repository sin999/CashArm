package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.02.14
 * Time: 7:42
 * To change this template use File | Settings | File Templates.
 */
public class OResourcePropEnums {
    public enum AccesToPersonalCabinet {
        oldBillingId(15088),    //ID из старого биллинга
        ttk_stat_comm(15128),   //ttk_stat_comm
        password(15127),        //Пароль
        passChryptMethod(14788),//Метод криптования пароля
        login(15126);           //Логин

        private double id;
        AccesToPersonalCabinet(int id){
            this.id=(double)id;
        }
        public double getId(){
            return id;
        }
    }

    public enum IpSubNetConnection{
        ttk_ip_netcust_comm(14952),
        ttk_ip_netcust(14951),
        ttk_vlan_idn(15288);
        private double id;

        IpSubNetConnection(int id){
            this.id=(double)id;
        }
        public double getId(){
            return id;
        }
        public static IpSubNetConnection getById(Double id){
            IpSubNetConnection retValue=null;
            if (id!=null){
                for (IpSubNetConnection connection: IpSubNetConnection.values()){
                    if (connection.getId() == id){
                        retValue=connection;
                    }
                }
            }
            return retValue;
        }
    }

    public enum ISGConnection {
        linkId(15289),//LinkID
        ttk_ip_nvl(15226),//ttk_ip_nvl
        ttk_static_address(14880),//
        connectionPortNumber(14876),//[ТТК] Номер порта подключения
        shpd_conn_comm(14832),//shpd_conn_comm
        passwordChryptMethod(14788),//Метод криптования пароля
        login(14786),//[ТТК] Логин
        password(14787),//[ТТК] Пароль
        etage(15027),//Этаж
        flatNumber(15026),//Номер квартиры
        addres(15029),//Адрес
        oldBillingId(15088),//ID из старого биллинга
        VLAN(15288),//VLAN
        podjezd(15028),//Подъезд
       ADDRES_DOM(14866);//Подъезд



        private double id;
        ISGConnection(int id){
            this.id=(double)id;
        }
        public double getId(){
            return id;
        }
        public static ISGConnection getById(Double id){
            ISGConnection retValue=null;
            if (id!=null){
                for (ISGConnection isgConnection: ISGConnection.values()){
                    if (isgConnection.getId() == id){
                        retValue=isgConnection;
                    }
                }
            }
            return retValue;
        }
    }

    public enum PhoneNumberConnection{
        ttk_tel_number(14937.0);
        private Double id;
        PhoneNumberConnection(Double id){
            this.id=id;
        }

        public Double getId() {
            return id;
        }

        public static PhoneNumberConnection getById(Double id){
            PhoneNumberConnection retValue=null;
            if (id!=null){
                for (PhoneNumberConnection phoneNumberConnection: PhoneNumberConnection.values()){
                    if (phoneNumberConnection.getId() == id){
                        retValue=phoneNumberConnection;
                    }
                }
            }
            return retValue;
        }
    }
}
