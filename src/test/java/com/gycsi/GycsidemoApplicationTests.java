package com.gycsi;

import com.gycsi.dao.RzxxDao;
import com.gycsi.dao.SfyzDao;
import com.gycsi.domain.B_Ryxx;
import com.gycsi.domain.Rzxx;
import com.gycsi.repository.BdxxRepository;
import com.gycsi.untils.Constants;
import com.gycsi.untils.MasUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GycsidemoApplication.class)
@WebAppConfiguration
public class GycsidemoApplicationTests {

	@Autowired
	SfyzDao sfyzDao;
	@Autowired
	BdxxRepository bdxxRepository;
	@Autowired
	RzxxDao rzxxDao;

	@Test
	public void contextLoads() throws Exception {
		saveRzxx();
	}

	public void find(){
		String nd="2016";
		String sfzh = "320721198205050011";
		B_Ryxx b_ryxxes = sfyzDao.findByNdAndSfzh(nd,sfzh);
	}

	@Test
	public void radom(){
		for (int j=0;j<100;j++) {
			String s = MasUtil.makeRandom();
			System.out.println(s);
		}

	}

	@Test
	public void resetBdxx() throws Exception {
		int t = bdxxRepository.resetBdxx("olqInwo-0tf6B8NYCUtPTfYN-YDo",new Date());
		System.out.println(t);

	}

	@Test
	public void rd(){
		for (int i=0;i<100;i++) {
			int t = (int)(Math.random()*32+1);

			System.out.println(String.valueOf((int)(Math.random()*32+1)));
		}

	}

	@Test
	public void findRzxx(){
		String nd="2016";
		String sfzh = "320721198205050011";
		Rzxx rzxx = rzxxDao.findRzxx(nd,sfzh);
		if (rzxx!=null) {
			System.out.println(rzxx.getSsb().getSm());
		}
	}

	@Test
	public void saveRzxx(){
		String ss = MasUtil.makeSSRandom();
		Rzxx new_rzxx = rzxxDao.addRzxx(Constants.ND, "320721198205050011", "0", ss, "钱锋");
	}


}
