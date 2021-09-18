package com.louis.boot.bean;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Louis {

    private String name;
    private Slave slave;

    public Louis() {
    }

    public Louis(String name, Slave slave) {
        this.name = name;
        this.slave = slave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Slave getSlave() {
        return slave;
    }

    public void setSlave(Slave slave) {
        this.slave = slave;
    }

    @Override
    public String toString() {
        return "Louis{" +
                "name='" + name + '\'' +
                ", slave=" + slave +
                '}';
    }
}
