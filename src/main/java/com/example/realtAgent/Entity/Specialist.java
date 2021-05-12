package com.example.realtAgent.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Specialist {
    private int idspecialist;
    private String name;
    private String surname;
    private Integer idagency;
    private String post;
    private Integer views;
    private String info;
    private Integer advertency;
    private Integer competence;
    private Integer responsibility;
    private Integer punctuality;
    private String img;
    private String city;
    private String suply;
    private Integer exp;
    private String idnum;

    @Id
    @Column(name = "idspecialist", nullable = false)
    public int getIdspecialist() {
        return idspecialist;
    }

    public void setIdspecialist(int idspecialist) {
        this.idspecialist = idspecialist;
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
    @Column(name = "surname", nullable = true, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "idagency", nullable = true)
    public Integer getIdagency() {
        return idagency;
    }

    public void setIdagency(Integer idagency) {
        this.idagency = idagency;
    }

    @Basic
    @Column(name = "post", nullable = true, length = 45)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "views", nullable = true)
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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
    @Column(name = "advertency", nullable = true)
    public Integer getAdvertency() {
        return advertency;
    }

    public void setAdvertency(Integer advertency) {
        this.advertency = advertency;
    }

    @Basic
    @Column(name = "competence", nullable = true)
    public Integer getCompetence() {
        return competence;
    }

    public void setCompetence(Integer competence) {
        this.competence = competence;
    }

    @Basic
    @Column(name = "responsibility", nullable = true)
    public Integer getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Integer responsibility) {
        this.responsibility = responsibility;
    }

    @Basic
    @Column(name = "punctuality", nullable = true)
    public Integer getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Integer punctuality) {
        this.punctuality = punctuality;
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
    @Column(name = "exp", nullable = true)
    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Basic
    @Column(name = "idnum", nullable = true, length = 45)
    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialist that = (Specialist) o;

        if (idspecialist != that.idspecialist) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (idagency != null ? !idagency.equals(that.idagency) : that.idagency != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (views != null ? !views.equals(that.views) : that.views != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (advertency != null ? !advertency.equals(that.advertency) : that.advertency != null) return false;
        if (competence != null ? !competence.equals(that.competence) : that.competence != null) return false;
        if (responsibility != null ? !responsibility.equals(that.responsibility) : that.responsibility != null)
            return false;
        if (punctuality != null ? !punctuality.equals(that.punctuality) : that.punctuality != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idspecialist;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (idagency != null ? idagency.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (advertency != null ? advertency.hashCode() : 0);
        result = 31 * result + (competence != null ? competence.hashCode() : 0);
        result = 31 * result + (responsibility != null ? responsibility.hashCode() : 0);
        result = 31 * result + (punctuality != null ? punctuality.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
