package com.example.realtAgent.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Infohome {
    private int id;
    private Integer room;
    private String address;
    private String city;
    private String action;
    private String picture;
    private Double price;
    private Boolean newflat;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "room", nullable = true)
    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "action", nullable = true, length = 45)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 100)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "newflat", nullable = true)
    public Boolean getNewflat() {
        return newflat;
    }

    public void setNewflat(Boolean newflat) {
        this.newflat = newflat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Infohome infohome = (Infohome) o;

        if (id != infohome.id) return false;
        if (room != null ? !room.equals(infohome.room) : infohome.room != null) return false;
        if (address != null ? !address.equals(infohome.address) : infohome.address != null) return false;
        if (city != null ? !city.equals(infohome.city) : infohome.city != null) return false;
        if (action != null ? !action.equals(infohome.action) : infohome.action != null) return false;
        if (picture != null ? !picture.equals(infohome.picture) : infohome.picture != null) return false;
        if (price != null ? !price.equals(infohome.price) : infohome.price != null) return false;
        if (newflat != null ? !newflat.equals(infohome.newflat) : infohome.newflat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (newflat != null ? newflat.hashCode() : 0);
        return result;
    }
}
