package com.gycsi.dao;

import com.gycsi.domain.Bdxx;
import com.gycsi.repository.BdxxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by qian-pc on 8/9/16.
 */
@Service
public class BdxxImpl implements BdxxDao {

    @Autowired
    BdxxRepository bdxxRepository;

    @Override
    public Boolean saveBdxx(String sfzh, String xm, String openid, String yxbz,String sjhm) {
        Bdxx bdxx = bdxxRepository.saveAndFlush(new Bdxx(sfzh,xm,openid,yxbz,sjhm));
        if (bdxx!=null) {
            return true;
        }
        return false;
    }

    @Override
    public Bdxx findByOpenid(String openid, String yxbz) {
        Bdxx bdxx = bdxxRepository.findByOpenidAndYxbz(openid,yxbz);
        return bdxx;
    }

    @Override
    public Boolean resetBdxx(String openid) {
        int i = bdxxRepository.resetBdxx(openid, new Date());
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }


}
