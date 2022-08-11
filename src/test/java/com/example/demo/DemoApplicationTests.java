package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.entity.DictDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.rabbitmq.Producer;
import com.example.demo.service.TcpService;
import com.example.demo.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
	@Autowired
	private TcpService tcpService;
	@Autowired
	private Producer producer;
	@Autowired
	private UserMapper userMapper;


	@Test
	void sendMsg() {
	  producer.sendMessgae("hello sunxian");
	  log.info("success");
	}

	@Test
	void contextLoads() {
		//ServerBootstrap bootstrap = new ServerBootstrap();
	}
	@Test
	void createXml(){
		try {
			String s=tcpService.createMsg();
			log.info(s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void send(){
		try {
			tcpService.sendMsg();
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void user(){
		User user = userMapper.selectById(1L);
		log.info(user.getUsername());
	}

	@Test
	void user1(){
		Date supplierShouldPayDate = getSupplierShouldPayDate(DateUtils.formatDate("2022-07-20"), "010003");
		log.info(supplierShouldPayDate.toString());
	}


	public Date getSupplierShouldPayDate(Date invoiceDate, String  dictDto) {
		if (dictDto.equals("010001")) {
			return invoiceDate;
		}

		int addDay = 28;
		int month = 0;

		String settleDes = "月结35";
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(settleDes);

		String dayStr = m.replaceAll("");

		if (StringUtils.isNotEmpty(dayStr)) {
			int day = Integer.valueOf(dayStr);

			month = (day / 30) + 1;
			addDay = day % 30;

			if (addDay == 0) {
				addDay = 28;
				month --;
			}
		}

		return DateUtils.getAfterDay(DateUtils.getBeforeMonth(DateUtils.getFirstDayOfMonth(invoiceDate), -month), addDay - 1);
	}


}
