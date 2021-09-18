package com.louis.boot.bean;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Slave {

    private String name;
    private String host;

    public Slave() {
    }

    public Slave(String name, String host) {
        this.name = name;
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Slave{" +
                "name='" + name + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
