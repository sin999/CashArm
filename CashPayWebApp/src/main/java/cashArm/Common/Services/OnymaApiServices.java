package cashArm.Common.Services;




import cashArm.Common.OEntityes.ConstantsNew.Groups;
import cashArm.Common.OEntityes.main.OContract;

import java.util.List;

/**
 * Created by Admin on 11.04.14.
 */
public interface OnymaApiServices {
    OContract getContract(String dogCode);
    OContract getContract(Double dogId);

    List<OContract> getAllContractsByGroup(Groups group);
    List<OContract> getAllContracts(Groups group, int startAt, Integer count);


}
