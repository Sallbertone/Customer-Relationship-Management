package mvc.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import mvc.entity.LoyaltyProgram;
import mvc.service.LoyaltyProgramService;


@Component
public class OlyOneIdToLoyaltyProgramListConverter implements Converter<String, List<LoyaltyProgram>>
{
	
	@Autowired
	LoyaltyProgramService loyaltyProgramService;
	
    public OlyOneIdToLoyaltyProgramListConverter()
    {

    }

	@Override
	public List<LoyaltyProgram> convert(String stringId)
	{
		List<LoyaltyProgram> programs = new ArrayList<>();
		
		int id = Integer.valueOf(stringId);
		programs.add(loyaltyProgramService.findLoyaltyProgramById(id));
					
		return programs;
	}


	
	

}
