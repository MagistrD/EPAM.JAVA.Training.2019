package by.epam.hospital.entities;


import java.sql.Date;

/**
 * entity that describe Medical history
 */
public class MedicalHistory {

    private int medicalHistoryID;
    private int patientID;
    private int diagnosedID;
    private Date dateOfReceipt;
    private Date dateOfDischarge;
    private String diagnosis;
    private String comment;
    private int appointmentID;

    /**
     * Constructor without parameters
     */
    public MedicalHistory() {
    }

    /**
     * Constructor with parameters
     *
     * @param medicalHistoryID Medical history ID
     * @param patientID        patient ID
     * @param diagnosedID      diagnosed ID
     * @param dateOfReceipt    date of receipt
     * @param dateOfDischarge  date of discharge
     * @param diagnosis        diagnosis
     * @param comment          comment
     * @param appointmentID    appointment id
     */
    public MedicalHistory(final int medicalHistoryID, final int patientID, final int diagnosedID,
                          final Date dateOfReceipt, final Date dateOfDischarge, final String diagnosis,
                          final String comment, final int appointmentID) {
        this.medicalHistoryID = medicalHistoryID;
        this.patientID = patientID;
        this.diagnosedID = diagnosedID;
        this.dateOfReceipt = dateOfReceipt;
        this.dateOfDischarge = dateOfDischarge;
        this.diagnosis = diagnosis;
        this.comment = comment;
        this.appointmentID = appointmentID;
    }

    /**
     * constructor with parameters
     *
     * @param patientID       id
     * @param diagnosedID     doctor
     * @param dateOfReceipt   date of receipt
     * @param dateOfDischarge date of discharged
     * @param diagnosis       diagnosis
     * @param comment         comment
     * @param appointmentID   appointment id
     */
    public MedicalHistory(final int patientID, final int diagnosedID, final Date dateOfReceipt,
                          final Date dateOfDischarge, final String diagnosis, final String comment,
                          final int appointmentID) {
        this.patientID = patientID;
        this.diagnosedID = diagnosedID;
        this.dateOfReceipt = dateOfReceipt;
        this.dateOfDischarge = dateOfDischarge;
        this.diagnosis = diagnosis;
        this.comment = comment;
        this.appointmentID = appointmentID;
    }

    /**
     * getter for Medical history ID
     *
     * @return medical history ID
     */
    public int getMedicalHistoryID() {
        return medicalHistoryID;
    }

    /**
     * setter for medical history ID
     *
     * @param medicalHistoryID medical history ID
     */
    public void setMedicalHistoryID(final int medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
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

    /**
     * getter for diagnosed ID
     *
     * @return Diagnosed ID
     */
    public int getDiagnosedID() {
        return diagnosedID;
    }

    /**
     * setter for Diagnosed ID
     *
     * @param diagnosedID diagnosed ID
     */
    public void setDiagnosedID(final int diagnosedID) {
        this.diagnosedID = diagnosedID;
    }

    /**
     * getter for date of receipt
     *
     * @return date of receipt
     */
    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    /**
     * setter for date of receipt
     *
     * @param dateOfReceipt date of receipt
     */
    public void setDateOfReceipt(final Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    /**
     * getter for date of discharged
     *
     * @return date of discharged
     */
    public Date getDateOfDischarge() {
        return dateOfDischarge;
    }

    /**
     * setter for date of discharged
     *
     * @param dateOfDischarge date of discharged
     */
    public void setDateOfDischarge(final Date dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    /**
     * setter for diagnosis
     *
     * @return diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * setter for diagnosis
     *
     * @param diagnosis diagnosis
     */
    public void setDiagnosis(final String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * getter for Comment
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * setter for comment
     *
     * @param comment comment
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * getter for appointment ID
     *
     * @return appointment ID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * setter for appointment ID
     *
     * @param appointmentID appointment ID
     */
    public void setAppointmentID(final int appointmentID) {
        this.appointmentID = appointmentID;
    }

    @Override
    public String toString() {
        return "MedicalHistory{"
                + "ID=" + medicalHistoryID
                + ", patient ID=" + patientID
                + ", diagnosed ID=" + diagnosedID
                + ", date Of Receipt=" + dateOfReceipt
                + ", date Of Discharge=" + dateOfDischarge
                + ", diagnosis='" + diagnosis + '\''
                + ", comment='" + comment + '\''
                + ", appointment ID=" + appointmentID
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalHistory that = (MedicalHistory) o;
        if (medicalHistoryID != that.medicalHistoryID) return false;
        if (patientID != that.patientID) return false;
        if (diagnosedID != that.diagnosedID) return false;
        if (appointmentID != that.appointmentID) return false;
        if (!dateOfReceipt.equals(that.dateOfReceipt)) return false;
        if (!dateOfDischarge.equals(that.dateOfDischarge)) return false;
        if (!diagnosis.equals(that.diagnosis)) return false;
        return comment.equals(that.comment);

    }

    @Override
    public int hashCode() {
        int result = medicalHistoryID;
        result = 31 * result + patientID;
        result = 31 * result + diagnosedID;
        result = 31 * result + dateOfReceipt.hashCode();
        result = 31 * result + dateOfDischarge.hashCode();
        result = 31 * result + diagnosis.hashCode();
        result = 31 * result + comment.hashCode();
        result = 31 * result + appointmentID;
        return result;
    }
}
