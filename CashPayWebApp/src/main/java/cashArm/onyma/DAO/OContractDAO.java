package cashArm.onyma.DAO;


import cashArm.onyma.DAO.Exceptions.NoSuchEntityExeption;
import cashArm.onyma.DAO.Exceptions.UnexpectedCountResults;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.Common.OEntityes.main.OContractAttribute;
import cashArm.onyma.common.DataChunk;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 17.12.13
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public interface OContractDAO {

    OContract findById(double id);
    //    pdogcode - номер договора
    OContract findByCode(String dogCode)  throws UnexpectedCountResults;

    void save(OContract contract) throws NoSuchEntityExeption;

    OContract findOrCreateByCode(String dogCode)  throws UnexpectedCountResults;
    List<OContract> findByCodeRAW(String dogCode);
    public List<OContract> findByCodePartRAW(String dogCodeStartWith);
    Map<Double,OContractAttribute> getSuppAttributeMap(OContract contract);
    List<OContract> findByAttributeValue(Double attrId, String attrValue);
    DataChunk<OContract> findPatternPartly(String dogCode,int rowsLimit,int rowsSkip );

}
