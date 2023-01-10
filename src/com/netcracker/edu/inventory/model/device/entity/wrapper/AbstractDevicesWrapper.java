package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.AllDevices;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.impl.Battery;
import com.netcracker.edu.inventory.model.device.entity.impl.Router;
import com.netcracker.edu.inventory.model.device.entity.impl.Switch;
import com.netcracker.edu.inventory.model.device.entity.impl.WifiRouter;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public class AbstractDevicesWrapper implements AllDevices {
    private Battery battery;
    private Router router;
    private Switch switchD;
    private WifiRouter wifiRouter;
    private Device device;

    public AbstractDevicesWrapper(Device device) {
        this.device = device;
        if (device instanceof Battery) {
            this.battery = (Battery) device;
        }
        if (device instanceof Router) {
            this.router = (Router) device;
            if (device instanceof Switch) {
                this.switchD = (Switch) device;
            }
            if (device instanceof WifiRouter) {
                this.wifiRouter = (WifiRouter) device;
            }
        }
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        device.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return device.getAllFields();
    }

    @Override
    public int getIn() {
        return device.getIn();
    }

    @Override
    public void setIn(int in) {
        device.setIn(in);
    }

    @Override
    public String getType() {
        return device.getType();
    }

    @Override
    public void setType(String type) {
        device.setType(type);
    }

    @Override
    public String getManufacturer() {
        return device.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        device.setManufacturer(manufacturer);
    }

    @Override
    public String getModel() {
        return device.getModel();
    }

    @Override
    public void setModel(String model) {
        device.setModel(model);
    }

    @Override
    public Date getProductionDate() {
        return device.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        device.setProductionDate(productionDate);
    }

    @Override
    public int getChargeVolume() {
        return battery.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        battery.setChargeVolume(chargeVolume);
    }

    @Override
    public int getDataRate() {
        return router.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        router.setDataRate(dataRate);
    }

    @Override
    public int getNumberOfPorts() {
        return switchD.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        switchD.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public ConnectorType getPortsType() {
        return switchD.getPortsType();
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        return switchD.getPortConnection(portNumber);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        switchD.setPortConnection(connection, portNumber);
    }

    @Override
    public List<Connection> getAllPortConnections() {
        return switchD.getAllPortConnections();
    }

    @Override
    public String getTechnologyVersion() {
        return wifiRouter.getTechnologyVersion();
    }

    @Override
    public String getSecurityProtocol() {
        return wifiRouter.getSecurityProtocol();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        wifiRouter.setSecurityProtocol(securityProtocol);
    }

    @Override
    public Connection getWirelessConnection() {
        return wifiRouter.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        wifiRouter.setWirelessConnection(wirelessConnection);
    }

    @Override
    public ConnectorType getWirePortType() {
        return wifiRouter.getWirePortType();
    }

    @Override
    public Connection getWireConnection() {
        return wifiRouter.getWireConnection();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        wifiRouter.setWireConnection(wireConnection);
    }

    @Override
    public int compareTo(Device o) {
        return device.compareTo(o);
    }
}
