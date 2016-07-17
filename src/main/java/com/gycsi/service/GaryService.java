package com.gycsi.service;

import com.gycsi.domain.Gary;
import org.springframework.stereotype.Service;

/**
 * Created by qian-pc on 7/12/16.
 */
@Service
public interface GaryService {
    Gary getGaryBySfzh(String sfzh);
    Iterable<Gary> getGaryByHid(String hid);
}
