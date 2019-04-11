/*
  Classes that describe subject area.
 */

package entities;

import entities.enumerations.DoctorType;

/**
 * Describe Doctor's entity.
 *
 * @author Vlad Litoshik
 * * @version 1.0
 */
public class Doctor {
    /**
     * Doctor's name.
     */
    private String firstName;
    /**
     * Doctor's second name.
     */
    private String secondName;
    /**
     * Doctor's surname.
     */
    private String surname;             // Doctor's surname
    /**
     * Doctor's type.
     */
    private DoctorType doctorType;      // Doctor's type

    /**
     * Constructor without parameters.
     */
    public Doctor() {
    }

    /**
     * Constructor with parameters.
     *
     * @param doctorType type of doctor
     * @param firstName  doctor's name
     * @param secondName doctor's second name
     * @param surname    doctor's surname
     */
    public Doctor(final String firstName, final String secondName, final String surname, final DoctorType doctorType) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.doctorType = doctorType;
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
     * setter for doctor's first name
     *
     * @param firstName first name of doctor
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for second name
     *
     * @return second name of doctor
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * setter for doctor's second name
     *
     * @param secondName doctor's second name
     */
    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    /**
     * getter for doctor's surname
     *
     * @return surname of doctor
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter for doctor's surname
     *
     * @param surname doctor's surname
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    /**
     * getter for doctor's type
     *
     * @return type of doctor
     */
    public DoctorType getDoctorType() {
        return doctorType;
    }

    /**
     * setter for doctor's type
     *
     * @param doctorType type of doctor
     */
    public void setDoctorType(final DoctorType doctorType) {
        this.doctorType = doctorType;
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
     * Doctor makes an appointment to the patient
     *
     * @param appointment appointment
     * @param patient     patient
     */
    public void makeAppointment(final Patient patient, final Appointment appointment) {

    }

    /**
     * Doctor performs the appointment
     *
     * @param patient     patient
     * @param appointment appointment
     */
    public void doAppointment(final Patient patient, final Appointment appointment) {

    }
}
