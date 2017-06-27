package szaqal.forkjoin.generators;

import org.apache.commons.lang.RandomStringUtils;

import szaqal.forkjoin.formatters.ItemFormatter;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class CanadaMsisdnGenerator extends AbstractItemGenerator<String> {
	
	public static final String CANADA_MSISDN_REGEX = "^1(204|250|289|306|403|416|418|450|506|514|519|604|613|647|705|778|780|709|807|819|867|902|905)[0-9]{7}$";

	private static final String [] AREACODES = new String [] {
		"204","250","289","306","403","416","418","450","506","514","519","604","613","647","705","778","780","709","807","819","867","902","905"
	};
	
	@Override
	public String generateItem(ItemFormatter<String> formatter) {
		return formatter.format("1" + AREACODES[RANDOM.nextInt(AREACODES.length)] + RandomStringUtils.randomNumeric(7));
	}

}
