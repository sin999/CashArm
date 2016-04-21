package cashArm.bbeans;

import cashArm.Common.OEntityes.ConstantsNew.UTID;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.bbeans.wrapers.AbstractContractWrapper;
import cashArm.bbeans.wrapers.FLContract;
import cashArm.bbeans.wrapers.ULContract;
import cashArm.onyma.DAO.PaymentDAO;
import cashArm.onyma.Services.ContractService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Admin on 16.10.14.
 */
@Named
public class DecoratedContractFactory implements Serializable{
    @Inject
    private PaymentDAO paymentDAO;
    @Inject
    private ContractService contractService;


    public AbstractContractWrapper decorateContract(OContract oContract){
        AbstractContractWrapper abstractContractWrapper=null;
        if (oContract!=null){
            switch (UTID.getByCode(oContract.getUtid())){
                case UL: abstractContractWrapper= new ULContract(oContract,paymentDAO,contractService);
                case FL: abstractContractWrapper= new FLContract(oContract,paymentDAO,contractService);
                default: abstractContractWrapper= new FLContract(oContract,paymentDAO,contractService);
            }
        }
        return abstractContractWrapper;
    }

}
