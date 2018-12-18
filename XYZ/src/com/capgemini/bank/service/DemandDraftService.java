package com.capgemini.bank.service;

import org.apache.log4j.*;


import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.dao.DemandDraftDAO;
import com.capgemini.bank.dao.IDemandDraftDAO;
import com.capgemini.bank.exceptions.InvalidAmountException;

public class DemandDraftService implements IDemandDraftService {

	IDemandDraftDAO demanddraftDao=new DemandDraftDAO(); 
	//Log4j implementation on DAO operations
	final static Logger logger=Logger.getLogger(DemandDraftService.class);
	
	//default Constructor
	public DemandDraftService() {
	}

	//OverLoaded Constructor
	public DemandDraftService(IDemandDraftDAO demanddraftdao) {
		this.demanddraftDao=demanddraftdao;
	}

	
	public int addDemandDraftDetails(DemandDraft demandDraft) {
		
	//if valid draft enter into database
		try {
			if(validdemanddraft(demandDraft))
			{
				logger.error("Database created succesfully");
			   return demanddraftDao.addDemandDraftDetails(demandDraft);
			}
			else if(demandDraft==null)
				throw new IllegalArgumentException();
			else
			{
				logger.error("Error in the Amount entered");
				throw new InvalidAmountException("Amount cannot be zero or less than zero");
			}
		} catch (Exception e) {
			logger.error("this is any other exception "+e);
			e.printStackTrace();
		}
		
	return 2;
		
	}
 // Validating the draft on the basis of amount
	private boolean validdemanddraft(DemandDraft demandDraft) {
		
		if(demandDraft.getDd_amount()>0)
		{
			return true;
		}
		
		return false;
	}
//method to get the draft details for particular transaction
	public DemandDraft getDemandDraftDetails(int transactionid) {
		return demanddraftDao.getDemandDraftDetails(transactionid);
	}

}
