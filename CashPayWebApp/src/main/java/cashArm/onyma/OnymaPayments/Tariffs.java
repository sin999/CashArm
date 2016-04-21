package cashArm.onyma.OnymaPayments;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.02.14
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
  public enum Tariffs{

        KACHAY(4436.0,Services.TestKACHAY),  //    Ф/Л, Уфа, ТТК Уфа Качай	 	                01.01.14	 	4436
        LETAY(3967.0,Services.TestLETAY),   //    Ф/Л, Уфа, ТТК Уфа Летай	 	                01.01.13	 	3967
        MECHTAY(3964.0,Services.TestMECHTAY), //    Ф/Л, Уфа, ТТК Уфа Мечтай	 	                24.09.13	 	3964
        KACHAY_PLUS_TV(4362.0,Services.TestKACHAY),  //    Ф/Л, Уфа, ТТК Качай + ТВ [ 80M / 550р]	 	01.12.13	 	4362
        LETAY_PLUS_TV(4363.0,Services.TestLETAY),   //    Ф/Л, Уфа, ТТК Летай + ТВ [100M / 650р]	 	01.12.13	 	4363
        MECHTAY_PLUS_TV(4360.0,Services.TestMECHTAY); //    Ф/Л, Уфа, ТТК Мечтай+ТВ [60M / 450р]	 	    01.12.13	 	4360

        private double id;
        private Services compensationService;

        Tariffs(Double id,Services compensationService){
            this.compensationService=compensationService;
            this.id=id;
        }
        public double getId(){
            return id;
        }
        public Services getCompensationService(){
            return compensationService;
        }

    public static Tariffs getById(Double id){
        Tariffs tariff=null;
        if(id!=null){
            for (Tariffs curTariff:Tariffs.values()){
                if(curTariff.getId()==id) {
                    tariff= curTariff;
                }
            }
        }
        return tariff;
    }
    public enum Services{
        TestKACHAY(1235.0,450.0),      //    Тест Качай	01.09.13	 	1235
        TestLETAY(1236.0,550.0),       //    Тест Летай	01.09.13	 	1236
        TestMECHTAY(1234.0,350.0);      //    Тест Мечтай	01.09.13	 	1234
        private double id,amount;
        Services(Double id,double amount){
               this.id=id;
               this.amount=amount;
        }
        public double getId(){
            return id;
        }
        public double getAmount(){
            return amount;
        }
    }

}