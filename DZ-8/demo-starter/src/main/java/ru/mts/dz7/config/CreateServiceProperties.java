package ru.mts.dz7.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "properties.animal.names")
public class CreateServiceProperties {
    private String[] catName;
    private String[] dogName;
    private String[] wolfName;
    private String[] sharkName;

    public String[] getCatName() {
        return catName;
    }

    public void setCatName(String[] catName) {
        this.catName = catName;
    }

    public String[] getDogName() {
        return dogName;
    }

    public void setDogName(String[] dogName) {
        this.dogName = dogName;
    }

    public String[] getWolfName() {
        return wolfName;
    }

    public void setWolfName(String[] wolfName) {
        this.wolfName = wolfName;
    }

    public String[] getSharkName() {
        return sharkName;
    }

    public void setSharkName(String[] sharkName) {
        this.sharkName = sharkName;
    }

}
