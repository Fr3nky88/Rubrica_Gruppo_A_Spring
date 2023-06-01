package it.develhope.gruppoa.rubrica.dao;

import it.develhope.gruppoa.rubrica.enums.Province;
import it.develhope.gruppoa.rubrica.model.Contatto;
import it.develhope.gruppoa.rubrica.model.Indirizzo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContattoDao {

    @Autowired
    @Qualifier("pippo")
    private JdbcTemplate jdbcTemplate;

    public List<Contatto> getContatti() {
        return jdbcTemplate.query(
                "SELECT c.id, c.nome, c.cognome, c.telefono, c.email, i.id as id_indirizzo, i.via, i.numero_civico, i.cap, i.citta, i.provincia " +
                        "FROM Contatto c " +
                        "JOIN Indirizzo i ON i.id = c.indirizzo", new RowMapper<Contatto>() {
                    public Contatto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Contatto c = new Contatto();
                        c.setId(BigInteger.valueOf(rs.getInt(1)));
                        c.setNome(rs.getString("nome"));
                        c.setCognome(rs.getString("cognome"));
                        c.setTelefono(rs.getString("telefono"));
                        c.setEmail(rs.getString("email"));
                        Indirizzo i = new Indirizzo();
                        i.setId(BigInteger.valueOf(rs.getInt(6)));
                        i.setVia(rs.getString("via"));
                        i.setNumeroCivico(rs.getString("numero_civico"));
                        i.setCap(rs.getString("cap"));
                        i.setCitta(rs.getString("citta"));
                        i.setProvincia(Province.valueOf(rs.getString("provincia")));
                        c.setIndirizzo(i);
                        return c;
                    }

                    ;
                });

    }



}
