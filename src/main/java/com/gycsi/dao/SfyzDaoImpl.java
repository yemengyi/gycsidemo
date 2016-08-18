package com.gycsi.dao;

import com.gycsi.domain.B_Ryxx;
import com.gycsi.repository.SfyzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qian-pc on 8/7/16.
 */
@Service
public class SfyzDaoImpl implements SfyzDao {

    @Autowired
    SfyzRepository sfyzRepository;

    @Override
    public B_Ryxx findByNdAndSfzh(String nd, String sfzh) {
        B_Ryxx.Id id =  new B_Ryxx.Id(nd,sfzh);
        return sfyzRepository.findOne(id);
    }
}
