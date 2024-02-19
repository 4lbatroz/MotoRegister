// Pakke- og import-setninger
package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository-klasse som håndterer databaseoperasjoner for motorvogner
@Repository
public class MotorvognRepository {

    // JdbcTemplate for enkel håndtering av JDBC-operasjoner
    private final JdbcTemplate jdbcTemplate;

    // Konstruktør som injiserer JdbcTemplate av Spring
    @Autowired
    public MotorvognRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Metode for å lagre en motorvogn i databasen
    public void lagreMotorvogn(Motorvogn motorvogn) {
        String sql = "INSERT INTO Motorvogn (personnr, navn, adresse, kjennetegn, merke, type) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, motorvogn.getPersonnr(), motorvogn.getNavn(), motorvogn.getAdresse(),
                motorvogn.getKjennetegn(), motorvogn.getMerke(), motorvogn.getType());
    }

    // Metode for å hente alle motorvogner fra databasen
    public List<Motorvogn> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn";
        // Bruker BeanPropertyRowMapper for å mappe radene til Motorvogn-objekter
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Motorvogn.class));
    }

    // Metode for å slette alle motorvogner fra databasen
    public void slettAlleMotorvogner() {
        String sql = "DELETE FROM Motorvogn";
        jdbcTemplate.update(sql);
    }
}
