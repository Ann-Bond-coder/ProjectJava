package com.netcracker.edu.inventory.model.device;

import com.netcracker.edu.inventory.model.NetworkElement;

import java.util.Date;

/**
 * The interface Device describe contract of mutable POJO,
 * witch represent device-entity as object.
 */
public interface Device extends NetworkElement<Device> {

    int getIn();

    void setIn(int in);

    String getType();

    void setType(String type);

    String getManufacturer();

    void setManufacturer(String manufacturer);

    String getModel();

    void setModel(String model);

    Date getProductionDate();

    void setProductionDate(Date productionDate);

}