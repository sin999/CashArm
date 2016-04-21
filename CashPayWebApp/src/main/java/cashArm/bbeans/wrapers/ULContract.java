package cashArm.bbeans.wrapers;

import cashArm.Common.OEntityes.ConstantsNew.ODogAttributes;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.onyma.DAO.PaymentDAO;
import cashArm.onyma.Services.ContractService;

/**
 * Created by Admin on 15.08.14.
 */
public class ULContract extends AbstractContractWrapper {
    public ULContract(OContract oContract,PaymentDAO paymentDAO,ContractService contractService){
        super(oContract,paymentDAO,contractService);
    }

    @Override
    public boolean isFl() {
        return false;
    }

    public String getShirtName(){
        return getProperty(ODogAttributes.organisationNameShirt);
    }

    public String getFullName(){
        return getProperty(ODogAttributes.organisationNameFull);
    }

    public String getUrAddress(){
        return getProperty(ODogAttributes.addressUr);
    }

    @Override
    public String getAgentName() {
        return (getShirtName()==null || getShirtName().equals(""))?getFullName():getFullName()+"("+getShirtName()+")";
    }

    @Override
    public String getAgentAddress() {
        return getUrAddress();
    }
}
