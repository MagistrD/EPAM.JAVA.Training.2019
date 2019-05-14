package by.epam.hospital.entities;

/**
 * entity Patient
 */
public class Patient extends People {

    private int patientID;

    /**
     * constructor without parameters
     */
    public Patient() {
    }

    /**
     * Constructor with parameters
     *
     * @param patientID  patient
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     */
    public Patient(final int patientID, final String firstName, final String secondName, final String surname) {
        super(firstName, secondName, surname);
        this.patientID = patientID;
    }

    /**
     * getter for patient ID
     *
     * @return patient ID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * setter for patient ID
     *
     * @param patientID patient ID
     */
    public void setPatientID(final int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Patient{"
                + "ID=" + patientID
                + "first name=" + getFirstName()
                + "second name=" + getSecondName()
                + "surname=" + getSurname()
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientID == patient.patientID;
    }

    @Override
    public int hashCode() {
        return patientID;
    }
}
