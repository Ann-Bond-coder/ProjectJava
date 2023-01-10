package com.netcracker.edu.inventory.model.impl;

public enum Type {
    need_init("<need_init>"),
    UTP("<UTP>"),
    FTP("<FTP>"),
    STP("<STP>"),
    SSFTP("<S/FTP>"),
    SFTP("<SFTP>");

    private String fullType;

    String getFullType() {
        return fullType;
    }
    Type(String fullType) {this.fullType = fullType;
    }
}