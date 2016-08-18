package com.gycsi.dao;

import com.gycsi.domain.Bdxx;
import org.springframework.stereotype.Service;

/**
 * Created by qian-pc on 8/9/16.
 */
@Service
public interface BdxxDao {
    Boolean saveBdxx(String sfzh,String xm,String openid,String yxbz,String sjhm);
    Bdxx findByOpenid(String openid,String yxbz);
    Boolean resetBdxx(String openid);
}
