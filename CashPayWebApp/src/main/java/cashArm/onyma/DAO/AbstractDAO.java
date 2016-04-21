package cashArm.onyma.DAO;

import ru.onyma.www.services.OnymaApi.OnymaApiSoapBindingStub;

import javax.inject.Inject;

/**
 * Created by Admin on 13.08.14.
 */
public class AbstractDAO {
    @Inject
    protected StubFactory stubFactory;

    public OnymaApiSoapBindingStub getStab(){
        return stubFactory.getOnymaStub();
    }


}
