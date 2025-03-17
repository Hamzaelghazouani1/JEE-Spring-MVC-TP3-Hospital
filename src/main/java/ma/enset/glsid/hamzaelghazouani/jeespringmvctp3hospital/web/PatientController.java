package ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.web;


import lombok.AllArgsConstructor;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.entities.Patient;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "1") int size){
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("patients",patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        return "patients";
    }
}
