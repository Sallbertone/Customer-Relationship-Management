package mvc.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.dao.LoyaltyProgramDAO;
import mvc.entity.LoyaltyProgram;

@Service
@Transactional
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService
{

	LoyaltyProgramDAO loyaltyProgramDAO;
	
	
	@Autowired
	public LoyaltyProgramServiceImpl(LoyaltyProgramDAO loyaltyProgramDAO)
	{
		this.loyaltyProgramDAO = loyaltyProgramDAO;
	}

	@Override
	public List<LoyaltyProgram> listAllLoyaltyPrograms()
	{
		return loyaltyProgramDAO.listAllLoyaltyPrograms();
	}

	@Override
	public Map<Integer, String> mapAllLoyaltyProgramsIdAndTitles()
	{
		return listAllLoyaltyPrograms().stream().collect(Collectors.toMap(LoyaltyProgram::getId, LoyaltyProgram::getTitle));		
	}

	@Override
	public void saveOrUpdateLoyaltyProgram(LoyaltyProgram loyaltyProgram)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<LoyaltyProgram> findLoyaltyProgram(String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findLoyaltyProgramById(int id)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLoyaltyProgram(int id)
	{
		// TODO Auto-generated method stub

	}


}
