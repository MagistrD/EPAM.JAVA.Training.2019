package by.epam.hospital.command;

import by.epam.hospital.command.entitiesCommand.*;

/**
 * enum of command from view in AJAX requests
 */
public enum CommandEnum {

    STAFF {
        {
            this.command = new StaffCommand();
        }
    },

    DOCTOR {
        {
            this.command = new DoctorCommand();
        }
    },

    NURSE {
        {
            this.command = new NurseCommand();
        }
    },

    PATIENT {
        {
            this.command = new PatientsCommand();
        }
    },

    SPECIALIZATION {
        {
            this.command = new SpecializationCommand();
        }
    },
    HISTORY {
        {
            this.command = new MedicalHistoryCommand();
        }
    },

    APPOINTMENT {
        {
            this.command = new AppointmentCommand();
        }
    },

    APPOINTMENTTYPE {
        {
            this.command = new AppointmentTypeCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
