package com.example.realtAgent.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agency {
    private int idagency;
    private String addres;
    private String name;
    private String tel;
    private String info;
    private String img;
    private String city;
    private String suply;
    private String link;

    @Id
    @Column(name = "idagency", nullable = false)
    public int getIdagency() {
        return idagency;
    }

    public void setIdagency(int idagency) {
        this.idagency = idagency;
    }

    @Basic
    @Column(name = "addres", nullable = true, length = 45)
    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 45)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "info", nullable = true, length = 45)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "img", nullable = true, length = 45)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
    @Column(name = "suply", nullable = true, length = 45)
    public String getSuply() {
        return suply;
    }

    public void setSuply(String suply) {
        this.suply = suply;
    }

    @Basic
    @Column(name = "link", nullable = true, length = 45)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agency agency = (Agency) o;

        if (idagency != agency.idagency) return false;
        if (addres != null ? !addres.equals(agency.addres) : agency.addres != null) return false;
        if (name != null ? !name.equals(agency.name) : agency.name != null) return false;
        if (tel != null ? !tel.equals(agency.tel) : agency.tel != null) return false;
        if (info != null ? !info.equals(agency.info) : agency.info != null) return false;
        if (img != null ? !img.equals(agency.img) : agency.img != null) return false;
        if (city != null ? !city.equals(agency.city) : agency.city != null) return false;
        if (suply != null ? !suply.equals(agency.suply) : agency.suply != null) return false;
        if (link != null ? !link.equals(agency.link) : agency.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagency;
        result = 31 * result + (addres != null ? addres.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (suply != null ? suply.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
}
