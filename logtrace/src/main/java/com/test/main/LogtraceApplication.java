package com.test.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class LogtraceApplication {

    private static final Logger logger = LoggerFactory.getLogger(LogtraceApplication.class);
    private static final boolean debugEnabled = logger.isDebugEnabled();
	
	public static void main(String[] args) {
		SpringApplication.run(LogtraceApplication.class, args);
	}
	
	@Scheduled(fixedDelay = 1000)
	public void fixedDelayTask() {
		try {
			List<Integer> list = null;
			list.add(100);
		} catch (Exception ex) {
			logger.error("Exception ", ex);
			ex.printStackTrace();
		}
	}

}
