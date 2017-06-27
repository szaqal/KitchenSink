package szaq.quartz;

import java.util.Properties;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Configuration
@ComponentScan("szaq.quarz")
@PropertySource("classpath:/application.properties")
public class QuartzApp {

	private static final Logger LOG = LoggerFactory.getLogger(QuartzApp.class);
	
	@Autowired
	private Environment environment;
	
	@Bean
	public SchedulerFactory schedulerFactoryBean() throws Exception {
		Properties quartzProperties  = getProperties();
		
		final JobDetail job = JobBuilder.newJob(RecurrentJob.class)
				.usingJobData("jobData", "I'm quartz job..")
				.withIdentity("testJob", "testJobs")
				.build();

		final CronTrigger cronTrigger = TriggerBuilder
				.newTrigger()
				.withIdentity("testTrigger", "testJobs")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/4 * * * * ?"))
				.forJob(job)
				.build();

		final SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory(quartzProperties);
		final Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.clear();
		scheduler.scheduleJob(job, cronTrigger);
		scheduler.start();
		
		LOG.info("Scheduler factory initialized");
		return schedulerFactoryBean;
	}

	private Properties getProperties() {
		final Properties quartzProperties = new Properties();
		quartzProperties.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
		quartzProperties.put("org.quartz.jobStore.isClustered", "TRUE");
		quartzProperties.put("org.quartz.jobStore.clusterCheckinInterval", "10000");
		quartzProperties.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
		quartzProperties.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
		quartzProperties.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		quartzProperties.put("org.quartz.threadPool.threadCount", "5");
		quartzProperties.put("org.quartz.scheduler.instanceId", "AUTO");
		quartzProperties.put("org.quartz.scheduler.instanceName", "qrtz");
		quartzProperties.put("org.quartz.jobStore.misfireThreshold", "10000");

		quartzProperties.put("org.quartz.jobStore.dataSource", "quartzDS");
		quartzProperties.put("org.quartz.dataSource.quartzDS.URL", environment.getRequiredProperty("org.quartz.dataSource.quartzDS.URL"));
		quartzProperties.put("org.quartz.dataSource.quartzDS.user", environment.getRequiredProperty("org.quartz.dataSource.quartzDS.user"));
		quartzProperties.put("org.quartz.dataSource.quartzDS.password", environment.getRequiredProperty("org.quartz.dataSource.quartzDS.password"));
		quartzProperties.put("org.quartz.dataSource.quartzDS.maxConnections", "5");
		quartzProperties.put("org.quartz.dataSource.quartzDS.validationQuery", "select 0 from dual");
		quartzProperties.put("org.quartz.dataSource.quartzDS.driver", environment.getRequiredProperty("org.quartz.dataSource.quartzDS.driver"));
		return quartzProperties;
	}	
}
