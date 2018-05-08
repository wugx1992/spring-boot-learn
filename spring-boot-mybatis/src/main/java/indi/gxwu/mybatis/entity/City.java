package indi.gxwu.mybatis.entity;

import java.util.Date;

public class City {
    private int id;
    private String country;
    private Date createDate;
    private String map;
    private String name;
    private String state;
    private String uuid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", createDate=" + createDate +
                ", map='" + map + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
