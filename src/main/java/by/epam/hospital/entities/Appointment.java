package by.epam.hospital.entities;

import java.util.Date;

/**
 * entity Appointment
 */
public class Appointment {

    private int appointmentID;
    private String description;
    private Date appointment;
    private Date execution;
    private int appointmentTypeID;
    private int executorID;

    /**
     * Constructor without parameters
     */
    public Appointment() {
    }

    /**
     * Constructor with parameters
     *
     * @param appointmentID     ID of appointment
     * @param description       Description of appointment
     * @param appointment       Date of appointment
     * @param execution         Date of execution
     * @param appointmentTypeID Type of appointment
     * @param executorID        Executor
     */
    public Appointment(final int appointmentID, final String description, final Date appointment, final Date execution,
                       final int appointmentTypeID, final int executorID) {
        this.appointmentID = appointmentID;
        this.description = description;
        this.appointment = appointment;
        this.execution = execution;
        this.appointmentTypeID = appointmentTypeID;
        this.executorID = executorID;
    }

    /**
     * Getter for appointment ID
     *
     * @return appointment ID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * Setter for appointment ID
     *
     * @param appointmentID appointment ID
     */
    public void setAppointmentID(final int appointmentID) {
        this.appointmentID = appointmentID;
    }

    /**
     * Getter for appointment's description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     *
     * @param description description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Getter for date of appointment
     *
     * @return date of appointment
     */
    public Date getAppointment() {
        return appointment;
    }

    /**
     * Setter for date of appointment
     *
     * @param appointment date of appointment
     */
    public void setAppointment(final Date appointment) {
        this.appointment = appointment;
    }

    /**
     * Getter for date of execution
     *
     * @return date of execution
     */
    public Date getExecution() {
        return execution;
    }

    /**
     * Setter for date of execution
     *
     * @param execution date of execution
     */
    public void setExecution(final Date execution) {
        this.execution = execution;
    }

    /**
     * Getter for appointment's type
     *
     * @return type of appointment
     */
    public int getAppointmentTypeID() {
        return appointmentTypeID;
    }

    /**
     * Setter for appointment's type
     *
     * @param appointmentTypeID type of appointment
     */
    public void setAppointmentTypeID(final int appointmentTypeID) {
        this.appointmentTypeID = appointmentTypeID;
    }

    /**
     * Getter for executor
     *
     * @return executor
     */
    public int getExecutorID() {
        return executorID;
    }

    /**
     * Setter for executor
     *
     * @param executorID executor
     */
    public void setExecutorID(final int executorID) {
        this.executorID = executorID;
    }

    /**
     * Override toString
     *
     * @return appointment
     */
    @Override
    public String toString() {
        return "Appointment{"
                + "ID=" + appointmentID
                + ", description='" + description + '\''
                + ", appointment=" + appointment
                + ", execution=" + execution
                + ", appointmentTypeID=" + appointmentTypeID
                + ", executorID=" + executorID
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        if (appointmentID != that.appointmentID) return false;
        if (appointmentTypeID != that.appointmentTypeID) return false;
        if (executorID != that.executorID) return false;
        if (!description.equals(that.description)) return false;
        if (!appointment.equals(that.appointment)) return false;
        return execution.equals(that.execution);
    }

    @Override
    public int hashCode() {
        int result = appointmentID;
        result = 31 * result + description.hashCode();
        result = 31 * result + appointment.hashCode();
        result = 31 * result + execution.hashCode();
        result = 31 * result + appointmentTypeID;
        result = 31 * result + executorID;
        return result;
    }
}
