package mvc.service;

import java.util.List;
import java.util.Map;

import mvc.entity.LoyaltyProgram;

public interface LoyaltyProgramService
{
	public List<LoyaltyProgram> listAllLoyaltyPrograms();
	
	public void saveOrUpdateLoyaltyProgram(LoyaltyProgram loyaltyProgram);
	
	public List<LoyaltyProgram> findLoyaltyProgram(String text);
	
	public LoyaltyProgram findLoyaltyProgramById(int id);
	
	public void deleteLoyaltyProgram(int id);
	
	public Map<Integer, String> mapAllLoyaltyProgramsIdAndTitles();
	
	
}
