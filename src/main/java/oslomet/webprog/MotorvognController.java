package oslomet.webprog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorvogn")
@CrossOrigin(origins = "http://localhost:8081")
class MotorvognController {

    @Autowired
    private MotorvognRepository rep;

    @PostMapping("/lagre")
    public void lagreMotorvogn(Motorvogn innMotorvogn) {
        rep.lagreMotorvogn(innMotorvogn);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlle() {
        return rep.hentAlleMotorvogner();
    }

    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettAlleMotorvogner();
    }
}