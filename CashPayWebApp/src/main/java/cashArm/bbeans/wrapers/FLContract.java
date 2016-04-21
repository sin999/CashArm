package cashArm.bbeans.wrapers;
import cashArm.Common.OEntityes.ConstantsNew.ODogAttributes;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.onyma.DAO.PaymentDAO;
import cashArm.onyma.Services.ContractService;

/**
 * Created by Admin on 14.08.14.
 */
public class FLContract  extends AbstractContractWrapper{
    public FLContract(OContract oContract,PaymentDAO paymentDAO,ContractService contractService){
        super(oContract,paymentDAO,contractService);
    }

    public String getMobilePhoneNumber(){
        return getProperty(ODogAttributes.phone);
    }

    public String getFIO(){
        return getProperty(ODogAttributes.FIO);
    }

    public String getPaperDogNumber(){
        return getProperty(ODogAttributes.paperDogNumber);
    }

    public String getFactAddress(){
        return getProperty(ODogAttributes.factAddress);
    }

    public String getCommonGroupFL(){
        return getProperty(ODogAttributes.commonGroupFL);
    }

    public String getGroup(){
        return getProperty(ODogAttributes.group);
    }


    @Override
    public boolean isFl() {
        return true;
    }

    @Override
    public String getAgentName() {
        return getFIO();
    }

    @Override
    public String getAgentAddress() {
        return getFactAddress();
    }
}
