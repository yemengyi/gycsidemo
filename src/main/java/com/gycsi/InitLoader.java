package com.gycsi;

import com.gycsi.domain.Gary;
import com.gycsi.repository.GaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by edwardlu on 2016/7/10.
 */
@Component
public class InitLoader implements ApplicationListener<ContextRefreshedEvent> {
    private GaryRepository garyRepository;

    @Autowired
    public void setGaryRepository(GaryRepository GaryRepository) {
        this.garyRepository = GaryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Gary gary = garyRepository.findOne("320721198205050011");
        if (gary == null) {
            System.out.println("不行a");
        }else {
            System.out.println(gary.getXm());

        }
    }
}
