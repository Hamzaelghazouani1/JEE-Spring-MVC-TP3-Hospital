package ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital;

import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.entities.Patient;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    private PatientRepository patientRepository;
    public HospitalApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Setter
        Patient patient = new Patient();
        patient.setNom("Hamza");
        patient.setDateNaissance(new Date());
        patient.setMalade(true);
        patient.setScore(190);

        //Constructor
        Patient patient2 = new Patient(null,"Saad",new Date(), true,17);

        //Builder
        Patient patient3 = Patient.builder()
                .nom("Houssam").
                dateNaissance(new Date())
                .malade(true)
                .score(20).
                build();

        patientRepository.save(patient);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
    }

}
