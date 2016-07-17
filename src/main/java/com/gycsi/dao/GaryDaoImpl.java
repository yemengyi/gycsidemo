package com.gycsi.dao;

import com.gycsi.domain.Gary;
import com.gycsi.rowmapper.GaryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by qian-pc on 7/16/16.
 */
@Service
public class GaryDaoImpl implements GaryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Gary> getGarys(String sfzh) {
        String sql = "select * from b_gary where hid in (select hid from b_gary where sfzh=?)";
//        String sql = "select * from b_gary where sfzh=?";
        List<Gary> garyList = jdbcTemplate.query(sql,new Object[]{sfzh},new GaryRowMapper());

        return garyList;
    }

    @Override
    public void getImageBySFZH(String SFZH, String fileName) {
        try {
            final OutputStream os = new FileOutputStream(new File(fileName));
            final LobHandler lobHandler = new DefaultLobHandler();
            jdbcTemplate.query("select zp from v_b where sfzh='" + SFZH + "'", new AbstractLobStreamingResultSetExtractor() {
                protected void streamData(ResultSet rs) {
                    try {
                        FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(rs,1), os);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
