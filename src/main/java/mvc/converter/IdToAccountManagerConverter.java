package mvc.converter;


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
	
    public IdToAccountManagerConverter()
    {

    }

	@Override
	public AccountManager convert(String stringId)
	{
		
		int id = Integer.valueOf(stringId);
		
		return accountManagerService.findAccountManagerById(id);
	}


	
	

}
