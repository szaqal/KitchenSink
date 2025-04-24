package szaqal.forkjoin.enums;

import szaqal.forkjoin.formatters.ItemFormatter;
import szaqal.forkjoin.generators.CanadaMsisdnGenerator;
import szaqal.forkjoin.generators.CompanyGenerator;
import szaqal.forkjoin.generators.FemalePersonGenerator;
import szaqal.forkjoin.generators.ItemGenerator;
import szaqal.forkjoin.generators.MalePersonGenerator;
import szaqal.forkjoin.generators.UsMsisdnGenerator;


/**
 * @author malczyk.pawel@gmail.com
 *
 */
public enum StringItemType implements ItemGenerator<String> {
	
	MALE_PERSON(new MalePersonGenerator("firstnames_male.txt","lastnames.txt")),
	FEMALE_PERSON(new FemalePersonGenerator("firstnames_female.txt", "lastnames.txt")),
	COMPANY(new CompanyGenerator("company_names.txt","company_types.txt")),
	US_MSISDN(new UsMsisdnGenerator()),
	CANADA_MSISDN(new CanadaMsisdnGenerator());
	
	
	private final ItemGenerator<String> generator;

	StringItemType(ItemGenerator<String> itemGenerator) {
		this.generator = itemGenerator;
	}

	@Override
	public String generateItem(ItemFormatter<String> formatter) {
		return generator.generateItem(formatter);
	}
}
