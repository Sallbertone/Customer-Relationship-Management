package mvc.dao;

import java.util.List;


import mvc.entity.LoyaltyProgram;

public interface LoyaltyProgramDAO
{
	public List<LoyaltyProgram> listAllLoyaltyPrograms();
	
	public void saveOrUpdateLoyaltyProgram(LoyaltyProgram loyaltyProgram);
	
	public List<LoyaltyProgram> findLoyaltyProgram(String text);
	
	public void findLoyaltyProgramById(int id);
	
	public void deleteLoyaltyProgram(int id);
	
	
}
