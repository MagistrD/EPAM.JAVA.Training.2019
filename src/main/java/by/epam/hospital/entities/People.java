package by.epam.hospital.entities;

/**
 * describe People
 */
public class People {

    private String firstName;
    private String secondName;
    private String surname;

    /**
     * constructor without parameters
     */
    public People() {
    }

    /**
     * constructor with parameters
     *
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     */
    public People(final String firstName, final String secondName, final String surname) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
    }

    /**
     * getter for first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for first name
     *
     * @param firstName first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for second name
     *
     * @return second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * setter for second name
     *
     * @param secondName second name
     */
    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    /**
     * getter for surname
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter for surname
     *
     * @param surname surname
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }


}
