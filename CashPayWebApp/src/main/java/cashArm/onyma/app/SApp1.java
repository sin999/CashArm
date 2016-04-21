package cashArm.onyma.app;




import cashArm.Common.OEntityes.main.OContract;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 18.12.13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public class SApp1 extends JFrame {
    OContract oContract=null;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SApp1();
            }
        });
    }
    SApp1(){
        String dog="731215232";
        oContract = getContract(dog);
        setName("My Onyma form");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private OContract getContract(String dog){
        OContract oContract=null;
        String username = "s.proskuryakov";
        String password = "rkby-OK";
        try{
//            OContractDAO oContractDAO=new OContractDAOImpl(username,password) ;
//            oContract=oContractDAO.findByPdogCode("021100009");
        }catch (Exception e){

        }
        return oContract;
    }



}
