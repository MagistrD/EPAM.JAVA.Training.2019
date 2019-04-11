package entities;

/**
 * Describe Nurse's entity
 */
public class Nurse {
    /**
     * Nurse's name
     */
    private String firstName;
    /**
     * Nurse's second name
     */
    private String secondName;
    /**
     * Nurse's surname
     */
    private String surname;

    /**
     * Constructor without parameters.
     */
    public Nurse() {
    }

    /**
     * Constructor with parameters.
     *
     * @param firstName  nurse's name
     * @param secondName nurse's second name
     * @param surname    nurse's surname
     */
    public Nurse(final String firstName, final String secondName, final String surname) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
    }

    /**
     * getter for nurse's name
     *
     * @return nurse's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for nurse's name
     *
     * @param firstName nurse's first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for nurse's second name
     *
     * @return nurse's secon name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * setter for nurse's name
     *
     * @param secondName nurse's second name
     */
    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    /**
     * getter for nurse's surname
     *
     * @return nurse's surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter for nurse's name
     *
     * @param surname nurse's surname
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Nurse performs the appointment
     *
     * @param patient     patient
     * @param appointment patient
     */
    public void doAppointment(final Patient patient, final Appointment appointment) {

    }
}
