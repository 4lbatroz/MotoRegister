package oslomet.webprog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorvognRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MotorvognRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void lagreMotorvogn(Motorvogn motorvogn) {
        String sql = "INSERT INTO Motorvogn (personnr, navn, adresse, kjennetegn, merke, type) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, motorvogn.getPersonnr(), motorvogn.getNavn(), motorvogn.getAdresse(),
                motorvogn.getKjennetegn(), motorvogn.getMerke(), motorvogn.getType());
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Motorvogn.class));
    }

    public void slettAlleMotorvogner() {
        String sql = "DELETE FROM Motorvogn";
        jdbcTemplate.update(sql);
    }
}

