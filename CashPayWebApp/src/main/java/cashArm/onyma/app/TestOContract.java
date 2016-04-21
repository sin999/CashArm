package cashArm.onyma.app;

import cashArm.onyma.Services.ContractService;
import cashArm.Common.OEntityes.main.OContract;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Admin on 12.08.14.
 */
@Named
public class TestOContract {
    @Inject
    private ContractService contractService;

    public OContract getContract(String docCode){
        OContract fullContract=contractService.getFullContract(docCode);
        return fullContract;
    }
}
