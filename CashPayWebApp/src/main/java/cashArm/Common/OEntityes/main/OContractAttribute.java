package cashArm.Common.OEntityes.main;

import java.io.Serializable;

/**
 * Created by Admin on 04.07.14.
 */
public class OContractAttribute  implements Serializable {
    private Double id;
    private String name;
    private String type;
    private String value;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
