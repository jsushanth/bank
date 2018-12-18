package com.capgemini.bank.dao;

import com.capgemini.bank.bean.DemandDraft;

public interface IDemandDraftDAO {


	public int addDemandDraftDetails(DemandDraft demandDraft);
	public DemandDraft getDemandDraftDetails(int transactionid); 
	
}
