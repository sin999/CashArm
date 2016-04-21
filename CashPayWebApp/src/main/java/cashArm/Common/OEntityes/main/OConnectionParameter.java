package cashArm.Common.OEntityes.main;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class OConnectionParameter  implements Serializable {
    private OConnection connection;
    private Double prop;
    private String val;
    private Double num;
    public OConnectionParameter(){

    }
    public OConnectionParameter(OConnection connection){
       this.connection=connection;
    }

//    <element name="prop" type="xs:double" nillable="true"/>
//    <element name="val" type="xs:string" nillable="true"/>
//    <element name="num" type="xs:double" nillable="true"/>

    @XmlTransient
    public OConnection getConnection() {
        return connection;
    }

    public void setConnection(OConnection connection) {
        this.connection = connection;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getProp() {
        return prop;
    }

    public void setProp(Double prop) {
        this.prop = prop;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
