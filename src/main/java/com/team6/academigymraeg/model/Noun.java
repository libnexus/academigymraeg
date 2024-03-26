package com.team6.academigymraeg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Noun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer nounID;

    @NotNull
    private String english;

    @NotNull
    private String welsh;

    @NotNull
    private Gender gender;

    /**
     * Zero length constructor is used so that developers are unable to create an empty Noun object.
     * The <code>protected</code> access modifier has been used so that Spring is still able to access
     * the constructor; Protected allows only the class itself and it's children to access the constructor.
     */
    protected Noun() {

    }


    /**
     * Constructor for the noun class which allows directly passing values for the noun to be created with.
     * Creating a new noun from inside the program without the aid of the JPA it should be ensured that the
     * noun ID that is trying to be used for the noun, if the purpose is to save the noun object to the
     * repository, is unique and doesn't identify another entry of a noun instance which already exists.
     *
     * @param english the English equivalent of the meaning of the noun
     * @param welsh the Welsh equivalent of the meaning of the noun
     * @param gender the gender of the noun (as it is used in Welsh)
     */
    public Noun(@NotNull String english, @NotNull String welsh, @NotNull Gender gender) {
        this.english = english;
        this.welsh = welsh;
        this.gender = gender;
    }

    public Integer getNounID() {
        return nounID;
    }

    public void setNounID(Integer nounID) {
        this.nounID = nounID;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getWelsh() {
        return welsh;
    }

    public void setWelsh(String welsh) {
        this.welsh = welsh;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
