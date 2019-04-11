package entities;

import entities.enumerations.AppointmentType;

/**
 * Describe Appointment's entity.
 */
public class Appointment {
    /**
     * Name of appointment.
     */
    private String name;
    /**
     * Type of appointment.
     */
    private AppointmentType appointmentType;

    /**
     * Constructor without parameters.
     */
    public Appointment() {
    }

    /**
     * Constructor with parameters.
     *
     * @param name            name of appointment.
     * @param appointmentType type of appointment.
     */
    public Appointment(final String name, final AppointmentType appointmentType) {
        this.name = name;
        this.appointmentType = appointmentType;
    }

    /**
     * getter for field 'name'.
     *
     * @return name of appointment
     */
    public String getName() {
        return name;
    }

    /**
     * setter for field 'name'.
     *
     * @param name name of appointment
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * getter for appointment type.
     *
     * @return appointment type
     */
    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    /**
     * setter for appointment type.
     *
     * @param appointmentType type of appointment
     */
    public void setAppointmentType(final AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
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
}
