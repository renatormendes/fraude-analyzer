package com.projeto.ml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IrisRequest {
    @JsonProperty("sepallength")
    private double sepallength;
    @JsonProperty("sepalwidth")
    private double sepalwidth;
    @JsonProperty("petallength")
    private double petallength;
    @JsonProperty("petalwidth")
    private double petalwidth;

    // Construtor vazio necessário para o Jackson
    public IrisRequest() {}

    // Getters e Setters
    public double getSepallength() { return sepallength; }
    public void setSepallength(double sepallength) { this.sepallength = sepallength; }
    public double getSepalwidth() { return sepalwidth; }
    public void setSepalwidth(double sepalwidth) { this.sepalwidth = sepalwidth; }
    public double getPetallength() { return petallength; }
    public void setPetallength(double petallength) { this.petallength = petallength; }
    public double getPetalwidth() { return petalwidth; }
    public void setPetalwidth(double petalwidth) { this.petalwidth = petalwidth; }
}
