package cashArm.onyma.DAO.Adapters;

import ru.onyma.www.services.OnymaApi.types.T_o_mdb_tt_props_row;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OConnectionParameter;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
public class ApiRow2ConnectionParameter extends OConnectionParameter implements Serializable {
    private T_o_mdb_tt_props_row propsRow;
    public ApiRow2ConnectionParameter(OConnection connection,T_o_mdb_tt_props_row propsRow){
     super(connection);
     this.propsRow=propsRow;
    }


    @Override
    public Double getNum() {
        return propsRow.getNum();
    }

    @Override
    public Double getProp() {
        return propsRow.getProp();
    }

    @Override
    public String getVal() {
        return propsRow.getVal();
    }

    @Override
    public void setNum(Double num) {
        propsRow.setNum(num);
    }

    @Override
    public void setProp(Double prop) {
        propsRow.setProp(prop);
    }

    @Override
    public void setVal(String val) {
        propsRow.setVal(val);
    }
}

