package mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mvc.entity.AccountManager;
import mvc.service.AccountManagerService;

@Component
public class IdToAccountManagerConverter implements Converter<Integer, AccountManager>
{
	
	@Autowired
	AccountManagerService accountManagerService;

	@Override
	public AccountManager convert(Integer id)
	{
		return this.accountManagerService.findAccountManagerById(id);
	}

}
