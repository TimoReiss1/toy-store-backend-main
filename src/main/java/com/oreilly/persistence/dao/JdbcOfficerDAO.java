package com.oreilly.persistence.dao;

import com.oreilly.persistence.entities.Officer;
import com.oreilly.persistence.entities.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings({"ConstantConditions", "SqlResolve", "SqlNoDataSourceInspection"})
@Repository
public class JdbcOfficerDAO implements OfficerDAO {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertOfficer;

    private final RowMapper<Officer> officerMapper =
            (ResultSet rs, int rowNum) -> new Officer(rs.getInt("id"),
                    Rank.valueOf(rs.getString("rank")),
                    rs.getString("first_name"),
                    rs.getString("last_name"));

    /*
    private final RowMapper<Toy> toyMapper =
            (ResultSet rs, int rowNum) -> new Officer(rs.getInt("id"),
                    Size.valueOf(rs.getString("toy_size")),
                    rs.getToyAttribute("toy_name"),
                    rs.getToyAttribute("toy_xy"));

     */

    @Autowired
    public JdbcOfficerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officers")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Officer save(Officer officer) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("rank", officer.getRank());
        parameters.put("first_name", officer.getFirstName());
        parameters.put("last_name", officer.getLastName());
        Integer newId = (Integer) insertOfficer.executeAndReturnKey(parameters);
        officer.setId(newId);
        return officer;
    }

    /*
    @Override
    public Toy save(Toy toy){
        //Fieldvariable: private final SimpleJdbcInsert insertToy;
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("toyAttribute", toy.getTheAttribute());
        parameters.put("toyAttribute", toy.getTheAttribute());
        parameters.put("toyAttribute", toy.getTheAttribute());
        parameters.put("toyAttribute", toy.getTheAttribute());
        Integer newId = (Integer) insertToy.executeAndReturnKey(parameters);
        toy.setId(newId);
        return Toy;
    }

     */

    @Override
    public Optional<Officer> findById(Integer id) {
        try (Stream<Officer> stream =
                     jdbcTemplate.queryForStream(
                             "select * from officers where id=?",
                             officerMapper,
                             id)) {
            return stream.findAny();
        }
    }

    // Alternative 1: extra SQL call to verify row exists
    @SuppressWarnings("unused")
    public Optional<Officer> findById1(Integer id) {
        if (!existsById(id)) return Optional.empty();
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM officers WHERE id=?",
                officerMapper,
                id));
    }

    /*
    @SuppressWarnings("unused")
    public Optional<Officer> findById1(Integer id) {
        if (!existsById(id)) return Optional.empty();
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM [database] WHERE id=?",
                [rowMapperObject],
                id));
    }
     */

    // Alternative 2: catch the exception when row doesn't exist
    @SuppressWarnings("unused")
    public Optional<Officer> findById2(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM officers WHERE id=?",
                    officerMapper,
                    id));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Officer> findAll() {
        return jdbcTemplate.query("SELECT * FROM officers", officerMapper);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from officers", Long.class);
    }

    @Override
    public void delete(Officer officer) {
        jdbcTemplate.update("DELETE FROM officers WHERE id=?", officer.getId());
    }

    @Override
    public boolean existsById(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT EXISTS(SELECT 1 FROM officers where id=?)", Boolean.class, id);
    }
}
