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

    // Metode for å lagre en motorvogn ved å håndtere en HTTP POST-forespørsel
    @PostMapping("/lagre")
    public void lagreMotorvogn(Motorvogn innMotorvogn) {
        rep.lagreMotorvogn(innMotorvogn);
    }

    // Metode for å hente alle motorvogner ved å håndtere en HTTP GET-forespørsel
    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlle() {
        return rep.hentAlleMotorvogner();
    }

    // Metode for å slette alle motorvogner ved å håndtere en HTTP GET-forespørsel
    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettAlleMotorvogner();
    }
}
