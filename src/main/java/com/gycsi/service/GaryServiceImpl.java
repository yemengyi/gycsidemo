package com.gycsi.service;

import com.gycsi.dao.GaryDao;
import com.gycsi.domain.Gary;
import com.gycsi.repository.GaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qian-pc on 7/12/16.
 */
@Service
public class GaryServiceImpl implements GaryService {

    private GaryRepository garyRepository;
    @Autowired
    GaryDao garyDao;

    @Autowired
    public void setGaryRepository(GaryRepository garyRepository) {
        this.garyRepository = garyRepository;
    }

    @Override
    public Gary getGaryBySfzh(String sfzh) {
        if (garyRepository == null) {
            System.out.println("garyRepository is null");
            return new Gary();
        }
        Gary gary = garyRepository.findOne(sfzh);
        return gary;
    }

    @Override
    public Iterable<Gary> getGaryByHid(String hid) {
        List<Gary> garyList = garyDao.getGarys(hid);
        return garyList;
    }
}
