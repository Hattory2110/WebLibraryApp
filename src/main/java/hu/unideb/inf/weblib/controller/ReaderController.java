package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.service.ReaderManagementService;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/read")
public class ReaderController {

    @Autowired
    ReaderManagementService service;

    @GetMapping("/registeredusers")
    public List<ReaderDTO> getAllReader(){
        return service.findAll();
    }

    @GetMapping("/reader")
    public ReaderDTO getReaderByOsz(@RequestParam Long osz){
        return service.findByOsz(osz);
    }

    @PostMapping("/save_reader")
    public ReaderDTO saveReader(@RequestBody ReaderDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/update_reader")
    public ReaderDTO updateReader(@RequestBody ReaderDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/delete_reader")
    public void deleteReader(@RequestParam Long osz){
        service.delete(osz);
    }
}
