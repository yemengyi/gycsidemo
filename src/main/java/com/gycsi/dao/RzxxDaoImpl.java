package com.gycsi.dao;

import com.gycsi.domain.Rzxx;
import com.gycsi.repository.RzxxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qian-pc on 8/14/16.
 */
@Service
public class RzxxDaoImpl implements RzxxDao {

    @Autowired
    RzxxRepository rzxxRepository;

    @Override
    public Rzxx findRzxx(String nd, String sfzh) {
        return rzxxRepository.findLastRzxx(nd,sfzh);
    }

    @Override
    public Rzxx addRzxx(String nd, String sfzh, String yxbz, String ssbh, String xm) {
        Rzxx rzxx = new Rzxx(nd,sfzh,xm,ssbh,"0");
        rzxxRepository.saveAndFlush(rzxx);
        return rzxx;
    }
}
