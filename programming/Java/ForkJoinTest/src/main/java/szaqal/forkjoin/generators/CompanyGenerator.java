package szaqal.forkjoin.generators;

import java.util.List;

import szaqal.forkjoin.formatters.ItemFormatter;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class CompanyGenerator extends AbstractItemGenerator<String> {
	
	private final String companyNames;
	
	private final String companyTypes;
	
	private static List<String> companyNameList;
	
	private static List<String> companyTypeList;
	
	
	public CompanyGenerator(String companyNames, String companyTypes) {
		this.companyNames = companyNames;
		this.companyTypes = companyTypes;
	}

	@Override
	public String generateItem(ItemFormatter<String> itemFormatter) {
		
		if(companyNameList == null) {
			companyNameList = loadAll(companyNames);
		}
		
		if(companyTypeList == null) {
			companyTypeList = loadAll(companyTypes);
		}
		return itemFormatter.format(randomGet(companyNameList) + " " + randomGet(companyTypeList));
	}

}
