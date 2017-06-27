package szaqal.forkjoin.generators;

import org.apache.commons.lang.RandomStringUtils;

import szaqal.forkjoin.formatters.ItemFormatter;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class UsMsisdnGenerator extends AbstractItemGenerator<String> {
	
	public static final String US_MSISDN_REGEX = "^1(242|246|264|268|284|345|441|456|473|649|664|684|758|767|784|809|829|868|869|876)[0-9]{7}$";
	
	
	private static final String [] AREACODES = new String[] {		
		"242","246","264","268","284","345","441","456","473","649","664","684","758","767","784","809","829","868","869","876"
	};

	@Override
	public String generateItem(ItemFormatter<String> formatter) {
		return formatter.format("1" + AREACODES[RANDOM.nextInt(AREACODES.length)] + RandomStringUtils.randomNumeric(7));
	}

}
