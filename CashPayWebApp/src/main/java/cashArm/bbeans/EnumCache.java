package cashArm.bbeans;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 16.10.14.
 */
public class EnumCache {
    private Map<String, Object> propertCache = new HashMap<String, Object>();
    private Map<String, Class>  baseCache = new HashMap<String, Class>();
    private static EnumCache staticEnumCache = null;

    public static EnumCache instance() {
        if (staticEnumCache == null) { staticEnumCache = new EnumCache(); }
        return staticEnumCache;
    }
    private EnumCache() {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        classes.add(PaymentReceipt.Status.class);

        for(Class clazz : classes) {
            try {
                baseCache.put(clazz.getSimpleName(), clazz);
                Method m = clazz.getMethod("values", (Class[]) null);
                Enum<?>[] valueList = (Enum[]) m.invoke(null, (Object[]) null);
                for (Enum<?> en : valueList) {
                    propertCache.put(clazz.getSimpleName() + "." + en.name(), en);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public Object getValueForKey(String key)  {
        return propertCache.get(key);
    }
    public Class getClassForKey(String key) {
        return baseCache.get(key);
    }
}
