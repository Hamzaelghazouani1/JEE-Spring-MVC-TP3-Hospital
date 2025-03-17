package ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.repository;

import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
