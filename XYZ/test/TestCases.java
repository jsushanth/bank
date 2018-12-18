

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.dao.IDemandDraftDAO;
import com.capgemini.bank.exceptions.InvalidAmountException;
import com.capgemini.bank.service.DemandDraftService;
import com.capgemini.bank.service.IDemandDraftService;

public class TestCases {

	//Object that to be proxied
	@Mock
	private IDemandDraftDAO demanddraftdao;
	private IDemandDraftService demanddraftservice;
	
	
	@Before
	public void setup()
	{
		//To initialize  proxy object 
		MockitoAnnotations.initMocks(this);
		demanddraftservice = new DemandDraftService(demanddraftdao);
	}
	
	
	@Test
	public void test_acc_with_proper_format()
	{
	    DemandDraft demandDraft=new DemandDraft("John","Capgemini","infof_capgemini",LocalDate.now(),5000,10,"7287996274");   
	    
	    //Dummy Declaration
	       Mockito.when(demanddraftdao.addDemandDraftDetails(demandDraft)).thenReturn(1);
	  //Actual logic Triggered
	    demanddraftservice.addDemandDraftDetails(demandDraft);
	   //mockito Verification 
	    Mockito.verify(demanddraftdao).addDemandDraftDetails(demandDraft);
	    
	    
	}
	@Test
	public void test_when_amount_lessthan_zero() throws InvalidAmountException
	{
		DemandDraft demandDraft = new DemandDraft("John","Capgemini","infof_capgemini",LocalDate.now(),-6000,10,"7287996274");
		demanddraftservice.addDemandDraftDetails(demandDraft);
		//assertEquals(-6000,demandDraft.getDd_amount(),0.0);
	}
	@Test
	public void test_when_demandDraft_null() throws InvalidAmountException
	{
		DemandDraft demandDraft = null;
		demanddraftservice.addDemandDraftDetails(demandDraft);
		
	}
}
