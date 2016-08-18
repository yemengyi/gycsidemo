package com.gycsi.dao;

import com.gycsi.domain.Rzxx;
import org.springframework.stereotype.Service;

/**
 * Created by qian-pc on 8/14/16.
 */
@Service
public interface RzxxDao {
    Rzxx findRzxx(String nd,String sfzh);
    Rzxx addRzxx(String nd,String sfzh,String yxbz,String ssbh,String xm);
}
