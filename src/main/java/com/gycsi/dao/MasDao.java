package com.gycsi.dao;

import com.gycsi.domain.C_Mas;
import org.springframework.stereotype.Service;

/**
 * Created by qian-pc on 8/8/16.
 */
@Service
public interface MasDao {
    C_Mas saveMas(String sjhm, String yzm, String yxbz);
    Boolean checkYZM(String sjhm,String yzm);
}
