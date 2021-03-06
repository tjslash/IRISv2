package ru.iris.common.devices;

/**
 * IRISv2 Project
 * Author: Nikolay A. Viguro
 * WWW: smart.ph-systems.ru
 * E-Mail: nv@ph-systems.ru
 * Date: 26.10.13
 * Time: 16:00
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import ru.iris.common.SQL;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class Device implements Serializable {

    @Expose
    protected String name = "not set";
    @Expose
    protected short node = 0;
    @Expose
    protected int zone = 0;
    @Expose
    protected String type = "unknown";
    @Expose
    protected String internalType = "unknown";
    @Expose
    protected String manufName = "unknown";
    @Expose
    protected String productName = "unknown";
    @Expose
    protected String uuid = "unknown";
    @Expose
    protected String status = "unknown";
    @Expose
    protected String source = "unknown";
    @Expose
    protected String internalName = "unknown";

    protected SQL sql;

    public Device() throws IOException, SQLException {
        sql = new SQL();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setProductName(String productName) {
            this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getSource() {
        return this.source;
    }

    public void setNode(short node) {
        this.node = node;
    }

    public short getNode() {
        return this.node;
    }

    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public int getZone() {
        return this.zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public String getType() {
        return this.type;
    }

    public void setInternalType(String type) {
        this.internalType = type;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getInternalType() {
        return this.internalType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufName() {
        return this.manufName;
    }

    public void setManufName(String manufName) {
        this.manufName = manufName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
