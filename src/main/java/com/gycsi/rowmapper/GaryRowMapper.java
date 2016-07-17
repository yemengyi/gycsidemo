package com.gycsi.rowmapper;

import com.gycsi.domain.Gary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by qian-pc on 7/16/16.
 */
public class GaryRowMapper implements RowMapper<Gary> {
    @Override
    public Gary mapRow(ResultSet resultSet, int i) throws SQLException {
        Gary gary = new Gary();

        gary.setDz(resultSet.getString("dz"));
        gary.setSfzh(resultSet.getString("sfzh"));
        gary.setXm(resultSet.getString("xm"));

        return gary;
    }
}