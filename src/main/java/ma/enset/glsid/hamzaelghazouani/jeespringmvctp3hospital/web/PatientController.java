package ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.web;


import lombok.AllArgsConstructor;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.entities.Patient;
import ma.enset.glsid.hamzaelghazouani.jeespringmvctp3hospital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "1") int size,
                        @RequestParam(name = "search", defaultValue = "") String search
                        ){
        Page<Patient> patients = patientRepository.findPatientByNomContains(search,PageRequest.of(page,size));
        model.addAttribute("patients",patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("search", search);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, String search, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&search="+search+"";
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/fromPatients")
    public String fromPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatients";
    }

    @PostMapping("save")
    public String save(Model model,Patient patient){
        patientRepository.save(patient);
        return "formPatients";
    }
}
