/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.Enterprise.Enterprise;
import business.Equipment.Equipment;
import business.Medication.Medicine;
import business.Network.Network;
import business.Organization.Organization;
import business.Role.AccountingAdminRole;
import business.Role.AmbulanceRole;
import business.Role.DoctorRole;
import business.Role.EmergencyAdminRole;
import business.Role.EquipmentAdminRole;
import business.Role.LabAssistantRole;
import business.Role.MedicineAdminRole;
import business.Role.PatientRole;
import business.Role.ReceptionistRole;
import business.Role.SystemAdminRole;
import business.Stakeholders.Ambulance;
import business.Stakeholders.Doctor;
import business.Stakeholders.Patient;
import business.UserAccount.UserAccount;

/**
 *
 * @author group42
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        Network network = system.addNetwork();
        network.setName("EnterpriseNetwork");

        //initialize some organizations
        Organization organization0 = system.getOrganizationDirectory().createOrganization(Organization.Type.ReceptionistOrg, "R1");
        Organization organization1 = system.getOrganizationDirectory().createOrganization(Organization.Type.DoctorOrg, "D1");
        Organization organization2 = system.getOrganizationDirectory().createOrganization(Organization.Type.PatientOrg, "P1");
        Organization organization3 = system.getOrganizationDirectory().createOrganization(Organization.Type.EquipmentOrg, "E1");
        Organization organization4 = system.getOrganizationDirectory().createOrganization(Organization.Type.LabOrg, "L1");
        Organization organization5 = system.getOrganizationDirectory().createOrganization(Organization.Type.MedicineOrg, "M1");
        Organization organization6 = system.getOrganizationDirectory().createOrganization(Organization.Type.AmbulanceOrg, "A1");
        Organization organization7 = system.getOrganizationDirectory().createOrganization(Organization.Type.BillingOrg, "B1");
        Organization organization8 = system.getOrganizationDirectory().createOrganization(Organization.Type.EmergencyOrg, "E2");

        //create an enterprises
        Enterprise enterprise0 = system.getEnterpriseDirectory().createEnterprise("Management Unit", Enterprise.EnterpriseType.ManagementEnt);
        Enterprise enterprise1 = system.getEnterpriseDirectory().createEnterprise("Equipment Unit", Enterprise.EnterpriseType.EquipmentEnt);
        Enterprise enterprise2 = system.getEnterpriseDirectory().createEnterprise("Emergency Unit", Enterprise.EnterpriseType.EmergencyEnt);
        Enterprise enterprise3 = system.getEnterpriseDirectory().createEnterprise("Medicine Unit", Enterprise.EnterpriseType.MedicineEnt);
        Enterprise enterprise4 = system.getEnterpriseDirectory().createEnterprise("Accounting Unit", Enterprise.EnterpriseType.AccountingEnt);
        Enterprise enterprise5 = system.getEnterpriseDirectory().createEnterprise("Ambulance Unit", Enterprise.EnterpriseType.AmbulanceEnt);

        //have some employees/stakeholders
        Doctor doctor = system.getDoctorDirectory().addNewDoctor("Doctor A", "MD", "Heart Surgeon", Boolean.TRUE, "doc");
        Patient patient = system.getPatientDirectory().addNewPatient("James Dash", "james@hotmail.com", "102-203-9870", 18, "park street", "james", "O+", "Doctor A", "M", "NYC");
        Ambulance ambulance = system.getAmbulanceDirectory().addNewAmbulance("Ramesh", "3345", "Roxbury");
        Equipment equipment = system.getEquipmentList().addEquipment("Ventilator", "GSG Ventilator", "20", 10, 200);
        Medicine medicine = system.getMedicineDirectory().addMedicine(1, "Crocin", "12/25/23", 5, 100);

        //create user account
        UserAccount ua0 = system.getUserAccountDirectory().createUserAccount("Systemdmin", "systemadmin", enterprise0, organization0, new SystemAdminRole());
        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("reception", "reception", enterprise0, organization0, new ReceptionistRole());
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("doctor", "doctor", enterprise0, organization1, new DoctorRole());
        UserAccount ua3 = system.getUserAccountDirectory().createUserAccount("john", "john", enterprise0, organization2, new PatientRole());
        UserAccount ua4 = system.getUserAccountDirectory().createUserAccount("max", "max", enterprise1, organization3, new EquipmentAdminRole());
        UserAccount ua5 = system.getUserAccountDirectory().createUserAccount("labassistant", "labassistant", enterprise3, organization4, new LabAssistantRole());
        UserAccount ua6 = system.getUserAccountDirectory().createUserAccount("medadmin", "medadmin", enterprise3, organization5, new MedicineAdminRole());
        UserAccount ua7 = system.getUserAccountDirectory().createUserAccount("ambrole", "ambulance", enterprise2, organization6, new AmbulanceRole());
        UserAccount ua8 = system.getUserAccountDirectory().createUserAccount("accadmin", "accadmin", enterprise4, organization7, new AccountingAdminRole());
        UserAccount ua9 = system.getUserAccountDirectory().createUserAccount("eradmin", "eradmin", enterprise2, organization8, new EmergencyAdminRole());

        return system;
    }

}
