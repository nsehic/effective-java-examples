package me.nerminsehic.item87;

import java.io.Serializable;

// Good candidate for default serialized form!
public class Name implements Serializable {
    /**
     * Last name. Must be non-null
     * @serial
     */
    private final String lastName;

    /**
     * First name. Must be non-null
     * @serial
     */
    private final String firstName;

    /**
     * Middle name, or null if there is none
     * @serial
     */
    private final String middleName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this("Nermin", null, "Sehic");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
