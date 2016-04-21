package cashArm.bbeans;

import javax.el.ELContext;
import javax.el.ELResolver;
import java.beans.FeatureDescriptor;
import java.util.Iterator;

/**
 * Created by Admin on 16.10.14.
 */
public class MyEnumResolver extends ELResolver {

    public Object getValue(ELContext context, Object base, Object property) {
        Object result = null;
        if (base == null) {
            result = EnumCache.instance().getClassForKey(property + "");
        } else if (base instanceof Class) {
            result = EnumCache.instance().getValueForKey(((Class) base).getSimpleName() + "." + property);
        }
        if (result != null) {
            context.setPropertyResolved(true);
        }
        return result;
    }

    public Class<?> getCommonPropertyType(ELContext context, Object base) {
        return null;
    }
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
        return null;
    }
    public Class<?> getType(ELContext context, Object base, Object property) {
        return null;
    }
    public boolean isReadOnly(ELContext context, Object base, Object property) {
        return false;
    }
    public void setValue(ELContext context, Object base, Object property, Object arg3) {
    }
}
