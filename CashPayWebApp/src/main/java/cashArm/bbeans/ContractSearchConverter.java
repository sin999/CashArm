package cashArm.bbeans;

import cashArm.Contract4Search;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Admin on 25.08.14.
 */
@Named
public class ContractSearchConverter implements Converter{
    @Inject
    private ContractFinder contractFinder;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Contract4Search contract4Search=contractFinder.getItemsMap().get(s);
        return contract4Search;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String retValue="Surprisingly null has been received, instead of a string for in converter ";
        if(o != null) {
            retValue = contractFinder.contract2String((Contract4Search) o);
        }
        return retValue;
    }


}
