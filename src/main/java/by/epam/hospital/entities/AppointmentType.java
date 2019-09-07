package by.epam.hospital.entities;

/**
 * entity appointment type
 */
public class AppointmentType {

    private int appointmentTypeID;

    private String appointmentTypeName;

    /**
     * Constructor without parameters
     */
    public AppointmentType() {
    }

    /**
     * Constructor with parameters
     *
     * @param appointmentTypeID   appointment type id
     * @param appointmentTypeName name of appointment type
     */
    public AppointmentType(final int appointmentTypeID, final String appointmentTypeName) {
        this.appointmentTypeID = appointmentTypeID;
        this.appointmentTypeName = appointmentTypeName;
    }

    /**
     * Getter for appointment type ID
     *
     * @return appointment type ID
     */
    public int getAppointmentTypeID() {
        return appointmentTypeID;
    }

    /**
     * Setter for appointment type ID
     *
     * @param appointmentTypeID id of appointment type
     */
    public void setAppointmentTypeID(final int appointmentTypeID) {
        this.appointmentTypeID = appointmentTypeID;
    }

    /**
     * Getter for appointment type name
     *
     * @return appointment type's name
     */
    public String getAppointmentTypeName() {
        return appointmentTypeName;
    }

    /**
     * Setter for appointment type name
     *
     * @param appointmentTypeName appointment type name
     */
    public void setAppointmentTypeName(final String appointmentTypeName) {
        this.appointmentTypeName = appointmentTypeName;
    }

    /**
     * Override toString
     *
     * @return appointment type
     */
    @Override
    public String toString() {
        return "AppointmentType{"
                + "ID=" + appointmentTypeID
                + ", appointmentTypeName='" + appointmentTypeName + '\''
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentType that = (AppointmentType) o;
        if (appointmentTypeID != that.appointmentTypeID) return false;
        return appointmentTypeName.equals(that.appointmentTypeName);
    }

    @Override
    public int hashCode() {
        int result = appointmentTypeID;
        result = 31 * result + appointmentTypeName.hashCode();
        return result;
    }
}
