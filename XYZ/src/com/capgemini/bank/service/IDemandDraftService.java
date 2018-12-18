package com.capgemini.bank.service;

import com.capgemini.bank.bean.DemandDraft;

public interface IDemandDraftService {

	
	public int addDemandDraftDetails(DemandDraft demandDraft);
	public DemandDraft getDemandDraftDetails(int transactionid); 
	
}
