package bean;

import java.io.Serializable;

public class lesBeans implements Serializable {

    private int id;
    private String nom;
    private String email;
    private String service;
    private String phone;
    private String typeAppareil;
    private String message;


    public lesBeans()
    {

    }

    public lesBeans(int id)
    {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(String typeAppareil) {
        this.typeAppareil = typeAppareil;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
