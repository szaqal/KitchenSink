package szaq.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class RecurrentJob  implements Job {
	
	private static final Logger LOG = LoggerFactory.getLogger(RecurrentJob.class);

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		final JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
		final String jobData = jobDataMap.getString("jobData");
		LOG.info("Hello... [{}]", jobData);
	}

}
