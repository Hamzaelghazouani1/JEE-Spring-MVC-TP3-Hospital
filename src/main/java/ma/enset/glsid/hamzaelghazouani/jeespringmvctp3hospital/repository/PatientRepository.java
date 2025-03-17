package ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.repository;

import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findPatientByNomContains(String search, Pageable pageable);

    @Query("SELECT p FROM Patient p WHERE p.nom LIKE :x")
    Page<Patient> chercher(@Param("x") String search, Pageable pageable);
}
