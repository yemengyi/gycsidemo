package com.gycsi.dao;

import com.gycsi.domain.B_Ryxx;
import org.springframework.stereotype.Service;

/**
 * Created by qian-pc on 8/7/16.
 */
@Service
public interface SfyzDao  {
    B_Ryxx findByNdAndSfzh(String nd,String sfzh);
}
