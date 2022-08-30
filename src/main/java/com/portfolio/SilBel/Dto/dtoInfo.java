
package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;


public class dtoInfo {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String profileImg;
    @NotBlank
    private String position;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String cvFile;
    @NotBlank
    private String mail;
    @NotBlank
    private String phone;
    @NotBlank
    private String city;
    @NotBlank
    private String country;

    public dtoInfo() {
    }

    public dtoInfo(String nombre, String apellido, String profileImg, String position, String aboutMe, String cvFile, String mail, String phone, String city, String country) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profileImg = profileImg;
        this.position = position;
        this.aboutMe = aboutMe;
        this.cvFile = cvFile;
        this.mail = mail;
        this.phone = phone;
        this.city = city;
        this.country = country;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getCvFile() {
        return cvFile;
    }

    public void setCvFile(String cvFile) {
        this.cvFile = cvFile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
