package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SynchronizedConnectionWrapper <D extends Device> extends AbstractConnectionWrapper<D>{

    public <T extends NetworkElement> SynchronizedConnectionWrapper(T connection) {
        super((Connection<D, D>) connection);
    }

    @Override
    public synchronized void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
    }

    @Override
    public synchronized Queue<Field> getAllFields() {
        return super.getAllFields();
    }

    @Override
    public synchronized ConnectorType getConnectorType() {
        return super.getConnectorType();
    }

    @Override
    public synchronized boolean addDevice(D device) {
        return super.addDevice(device);
    }

    @Override
    public synchronized boolean removeDevice(D device) {
        return super.removeDevice(device);
    }

    @Override
    public synchronized boolean containDevice(D device) {
        return super.containDevice(device);
    }

    @Override
    public synchronized Set<D> getAllDevices() {
        return super.getAllDevices();
    }

    @Override
    public synchronized int getCurSize() {
        return super.getCurSize();
    }

    @Override
    public synchronized int getMaxSize() {
        return super.getMaxSize();
    }

    @Override
    public synchronized Trunk getTrunk() {
        return super.getTrunk();
    }

    @Override
    public synchronized void setTrunk(Trunk trunk) {
        super.setTrunk(trunk);
    }

    @Override
    public synchronized int getSerialNumber() {
        return super.getSerialNumber();
    }

    @Override
    public synchronized void setSerialNumber(int serialNumber) {
        super.setSerialNumber(serialNumber);
    }

    @Override
    public synchronized String getStatus() {
        return super.getStatus();
    }

    @Override
    public synchronized void setStatus(String status) {
        super.setStatus(status);
    }

    @Override
    public synchronized ConnectorType getAPointConnectorType() {
        return super.getAPointConnectorType();
    }

    @Override
    public synchronized ConnectorType getBPointConnectorType() {
        return super.getBPointConnectorType();
    }

    @Override
    public synchronized D getAPoint() {
        return super.getAPoint();
    }

    @Override
    public synchronized void setAPoint(D device) {
        super.setAPoint(device);
    }

    @Override
    public synchronized D getBPoint() {
        return super.getBPoint();
    }

    @Override
    public synchronized void setBPoint(D device) {
        super.setBPoint(device);
    }

    @Override
    public synchronized List<D> getBPoints() {
        return super.getBPoints();
    }

    @Override
    public synchronized void setBPoints(List<D> devices) {
        super.setBPoints(devices);
    }

    @Override
    public synchronized int getBCapacity() {
        return super.getBCapacity();
    }

    @Override
    public synchronized D getBPoint(int deviceNumber) {
        return super.getBPoint(deviceNumber);
    }

    @Override
    public synchronized void setBPoint(D device, int deviceNumber) {
        super.setBPoint(device, deviceNumber);
    }

    @Override
    public synchronized int compareTo(Connection o) {
        return super.compareTo(o);
    }

    @Override
    public synchronized Mode getMode() {
        return super.getMode();
    }

    @Override
    public synchronized Type getType() {
        return super.getType();
    }

    @Override
    public synchronized int getLength() {
        return super.getLength();
    }

    @Override
    public synchronized void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public synchronized String getTechnology() {
        return super.getTechnology();
    }

    @Override
    public synchronized String getProtocol() {
        return super.getProtocol();
    }

    @Override
    public synchronized void setProtocol(String protocol) {
        super.setProtocol(protocol);
    }

    @Override
    public synchronized int getVersion() {
        return super.getVersion();
    }

    @Override
    public synchronized void setVersion(int version) {
        super.setVersion(version);
    }

    @Override
    public synchronized int hashCode() {
        return super.hashCode();
    }

    @Override
    public synchronized boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }

    @Override
    protected synchronized void finalize() throws Throwable {
        super.finalize();
    }
}
