package mvc.converter;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import mvc.entity.AccountManager;
import mvc.service.AccountManagerService;


@Component
public class IdToAccountManagerConverter implements Converter<String, AccountManager>
{
	
	@Autowired
	AccountManagerService accountManagerService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
    public IdToAccountManagerConverter()
    {
        logger.info("==========>>>       IdToAccountManagerConverter picked up");
    }

	@Override
	public AccountManager convert(String stringId)
	{
		logger.info("==========>>>       convert method called");
		
		int id = Integer.valueOf(stringId);
		
		//this line is not working 
		AccountManager am = accountManagerService.findAccountManagerById(id);
		
		logger.info("==========>>>       Account manager " + am + " successfully fetched" );
		
		return am;
	}


	
	

}
