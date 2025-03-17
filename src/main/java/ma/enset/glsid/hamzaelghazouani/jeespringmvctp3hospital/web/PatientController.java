package ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.web;


import lombok.AllArgsConstructor;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.entities.Patient;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients",patients);
        return "patients";
    }
}
