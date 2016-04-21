package cashArm.Common.OEntityes.Wrappers;


import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 8:52
 * To change this template use File | Settings | File Templates.
 */
public class OConnectionWrapper extends OConnection implements Serializable {
    private OConnection connection;
    public OConnectionWrapper(OConnection connection){
        super(connection.getAuthName());
        this.connection=connection;
    }

    @Override
    @XmlTransient
    public OAuthName getAuthName() {
        return connection.getAuthName();
    }

    @Override
    public String getConn_name() {
        return connection.getConn_name();
    }

    @Override
    public Date getDadd() {
        return connection.getDadd();
    }

    @Override
    public Double getDmid() {
        return connection.getDmid();
    }

    @Override
    public Double getDogid() {
        return connection.getDogid();
    }

    @Override
    public Date getEnddate() {
        return connection.getEnddate();
    }

    @Override
    public Date getEnddatetime() {
        return connection.getEnddatetime();
    }

    @Override
    public Double getGid() {
        return connection.getGid();
    }

    @Override
    public Double getId() {
        return connection.getId();
    }

    @Override
    public String getLastop() {
        return connection.getLastop();
    }

    @Override
    public String getName() {
        return connection.getName();
    }

    @Override
    public String getNotes() {
        return connection.getNotes();
    }

    @Override
    public Double getService() {
        return connection.getService();
    }

    @Override
    public String getShared() {
        return connection.getShared();
    }

    @Override
    public Date getStartdate() {
        return connection.getStartdate();
    }

    @Override
    public Date getStartdatetime() {
        return connection.getStartdatetime();
    }

    @Override
    public Double getStatus() {
        return connection.getStatus();
    }

    @Override
    public Double getStatus_qualif() {
        return connection.getStatus_qualif();
    }

    @Override
    public Double getTmid() {
        return connection.getTmid();
    }

    @Override
    public void setAuthName(OAuthName authName) {
        connection.setAuthName(authName);
    }

    @Override
    public void setConn_name(String conn_name) {
        connection.setConn_name(conn_name);
    }

    @Override
    public void setDadd(Date dadd) {
        connection.setDadd(dadd);
    }

    @Override
    public void setDmid(Double dmid) {
        connection.setDmid(dmid);
    }

    @Override
    public void setDogid(Double dogid) {
        connection.setDogid(dogid);
    }

    @Override
    public void setEnddate(Date enddate) {
        connection.setEnddate(enddate);
    }

    @Override
    public void setEnddatetime(Date enddatetime) {
        connection.setEnddatetime(enddatetime);
    }

    @Override
    public void setGid(Double gid) {
        connection.setGid(gid);
    }

    @Override
    public void setId(Double id) {
        connection.setId(id);
    }

    @Override
    public void setLastop(String lastop) {
        connection.setLastop(lastop);
    }

    @Override
    public void setName(String name) {
        connection.setName(name);
    }

    @Override
    public void setNotes(String notes) {
        connection.setNotes(notes);
    }

    @Override
    public void setService(Double service) {
        connection.setService(service);
    }

    @Override
    public void setShared(String shared) {
        connection.setShared(shared);
    }

    @Override
    public void setStartdate(Date startdate) {
        connection.setStartdate(startdate);
    }

    @Override
    public void setStartdatetime(Date startdatetime) {
        connection.setStartdatetime(startdatetime);
    }

    @Override
    public void setStatus(Double status) {
        connection.setStatus(status);
    }

    @Override
    public void setStatus_qualif(Double status_qualif) {
        connection.setStatus_qualif(status_qualif);
    }

    @Override
    public void setTmid(Double tmid) {
        connection.setTmid(tmid);
    }
}
