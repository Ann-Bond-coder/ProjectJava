package com.netcracker.edu.inventory.model.device.entity;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;

public interface WifiRouter extends Router {

    String getTechnologyVersion();

    String getSecurityProtocol();

    void setSecurityProtocol(String securityProtocol);

    Connection getWirelessConnection();

    void setWirelessConnection(Connection wirelessConnection);

    ConnectorType getWirePortType();

    Connection getWireConnection();

    void setWireConnection(Connection wireConnection);
}
