package entities;

import java.util.Date;

/**
 * Describe Patient's entity
 */
public class Patient {
    /**
     * Patien's name
     */
    private String firstName;
    /**
     * Patien's second name
     */
    private String secondName;
    /**
     * Patien's surname
     */
    private String surname;

    /**
     * Date of admission to hospital
     */
    private Date dateOfAdmission;

    /**
     * Patient discharge dates
     */
    private Date dateOfDischarge;

    /**
     * Patient appointments
     */
    private Appointment appointment;

    /**
     * Attending doctor
     */
    private Doctor doctor;
    /**
     * Attending nurse
     */
    private Nurse nurse;

    /**
     * Constructor without parameters.
     */
    public Patient() {
    }

    /**
     * Constructor with parameters
     *
     * @param firstName       patient first name
     * @param secondName      patient second name
     * @param surname         patient surname
     * @param dateOfAdmission date of admission
     * @param dateOfDischarge date od discharge
     * @param doctor          doctor
     * @param appointment     appointment
     * @param nurse           nurse
     */
    public Patient(final String firstName, final String secondName, final String surname, final Date dateOfAdmission,
                   final Date dateOfDischarge, final Appointment appointment, final Doctor doctor, final Nurse nurse) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.dateOfAdmission = dateOfAdmission;
        this.dateOfDischarge = dateOfDischarge;
        this.appointment = appointment;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    /**
     * getter for patient's doctor
     *
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * setter for patient's doctor
     *
     * @param doctor doctor
     */
    public void setDoctor(final Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * getter for patient's nurse
     *
     * @return nurse
     */
    public Nurse getNurse() {
        return nurse;
    }

    /**
     * setter for patient's nurse
     *
     * @param nurse nurse
     */
    public void setNurse(final Nurse nurse) {
        this.nurse = nurse;
    }

    /**
     * getter for patient's first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for patient's first name
     *
     * @param firstName first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for patient's second name
     *
     * @return second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * setter for patient's second name
     *
     * @param secondName second name
     */
    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    /**
     * getter for patient's surname
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter for patient's surname
     *
     * @param surname surname
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    /**
     * getter for date of admission
     *
     * @return date of admission
     */
    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    /**
     * setter for date of admission
     *
     * @param dateOfAdmission date of admission
     */
    public void setDateOfAdmission(final Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    /**
     * getter for date of discharge
     *
     * @return date of discharge
     */
    public Date getDateOfDischarge() {
        return dateOfDischarge;
    }

    /**
     * setter for date of discharge
     *
     * @param dateOfDischarge date of discharge
     */
    public void setDateOfDischarge(final Date dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    /**
     * getter for appointment
     *
     * @return appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * setter for appointment
     *
     * @param appointment appointment
     */
    public void setAppointment(final Appointment appointment) {
        this.appointment = appointment;
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
     * Patient go to hospital
     *
     * @param doctor          doctor
     * @param dateOfAdmission date of admission
     */
    public void goToHospital(final Doctor doctor, final Date dateOfAdmission) {

    }

    /**
     * Patient discharge from hospital
     *
     * @param dateOfDischarge date of discharge
     */
    public void dischargeFromHospital(final Date dateOfDischarge) {

    }
}
