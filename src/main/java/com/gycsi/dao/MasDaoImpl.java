package com.gycsi.dao;

import com.gycsi.domain.C_Mas;
import com.gycsi.repository.MasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by qian-pc on 8/8/16.
 */
@Service
public class MasDaoImpl implements MasDao {

    @Autowired
    MasRepository masRepository;

    @Override
    public C_Mas saveMas(String sjhm, String yzm ,String yxbz) {
        C_Mas c_mas = new C_Mas(sjhm, yzm,yxbz);
        return masRepository.saveAndFlush(c_mas);
    }

    @Override
    public Boolean checkYZM(String sjhm, String yzm) {
        String currentYzm = masRepository.findCurrentYzm(sjhm);
        if (currentYzm!=null&&currentYzm.equals(yzm)) {
            return true;
        }
        return false;
    }
}
