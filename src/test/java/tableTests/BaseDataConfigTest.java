package tableTests;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import persistence.PersistenceUtil;
import queries.QueryBase_Data;
import entityCreator.EntityCreator;
import model.Base_Data;
import model.Event_Cause;
import model.Failure;
import model.TableRow;
import model.Operator;
import model.User_Equipment;

public class BaseDataConfigTest extends AbstractTestConfig {

	@Override
	public void testCreateDeleteRow() {
		
		QueryBase_Data queryBaseData = new QueryBase_Data();
		
		Failure f = EntityCreator.getFailure(10, "Test Description");
		User_Equipment ue = EntityCreator.getUser_Equipment(991, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		Event_Cause ec = EntityCreator.getEvent_Cause(0, 4097, "RRC CONN SETUP-SUCCESS");
		Operator o = EntityCreator.getOperator(201, 4, "Ireland", "TDC-DK");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 11, 17, 15);
		Date dateTime = new Date();
		dateTime.setTime(cal.getTimeInMillis());
		BigInteger hier3Id = new BigInteger("4809532081614990336");
		BigInteger hier32Id = new BigInteger("8226896360947470336");
		BigInteger hier321Id = new BigInteger("115044494090947993");
		BigInteger imsi = new BigInteger("344930000000011");
		String neVersion = "11B";
		
		PersistenceUtil.persist(f);
		PersistenceUtil.persist(ue);
		PersistenceUtil.persist(ec);
		PersistenceUtil.persist(o);
		
		Base_Data expected = EntityCreator.getBase_Data(4, dateTime, 1000, hier3Id, hier32Id, hier321Id, imsi, neVersion, 
				f, ue, ec, o);
		
		PersistenceUtil.persist(expected);
		
		Base_Data result = (Base_Data) queryBaseData.findRowById(expected.getDataId());
		PersistenceUtil.remove(expected);
		
		PersistenceUtil.remove(f);
		PersistenceUtil.remove(ue);
		PersistenceUtil.remove(ec);
		PersistenceUtil.remove(o);
		
		assertNotNull(result);
		assertEquals(expected.getCellId(), result.getCellId());
	}


	@Override
	public void testList() {
		
		QueryBase_Data queryBaseData = new QueryBase_Data();
		
		Failure f = EntityCreator.getFailure(15, "Test Description");
		Failure f2 = EntityCreator.getFailure(11, "Test Description");
		User_Equipment ue = EntityCreator.getUser_Equipment(995, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		User_Equipment ue2 = EntityCreator.getUser_Equipment(992, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", "test1", "test1", "test1");
		Event_Cause ec = EntityCreator.getEvent_Cause(0, 4098, "RRC CONN SETUP-SUCCESS");
		Event_Cause ec2 = EntityCreator.getEvent_Cause(1, 4098, "RRC CONN SETUP-SUCCESS");
		Operator o = EntityCreator.getOperator(203, 4, "Ireland", "TDC-DK");
		Operator o2 = EntityCreator.getOperator(202, 4, "Ireland", "TDC-DK");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 11, 17, 15);
		Date dateTime = new Date();
		dateTime.setTime(cal.getTimeInMillis());
		BigInteger hier3Id = new BigInteger("4809532081614990336");
		BigInteger hier32Id = new BigInteger("8226896360947470336");
		BigInteger hier321Id = new BigInteger("115044494090947993");
		BigInteger imsi = new BigInteger("344930000000011");
		String neVersion = "11B";
		
		PersistenceUtil.persist(f);
		PersistenceUtil.persist(ue);
		PersistenceUtil.persist(ec);
		PersistenceUtil.persist(o);
		PersistenceUtil.persist(f2);
		PersistenceUtil.persist(ue2);
		PersistenceUtil.persist(ec2);
		PersistenceUtil.persist(o2);
		
		Base_Data row = EntityCreator.getBase_Data(4, dateTime, 1000, hier3Id, hier32Id, hier321Id, imsi, neVersion, f, ue, ec, o);
		Base_Data row2 = EntityCreator.getBase_Data(4, dateTime, 1001, hier3Id, hier32Id, hier321Id, imsi, neVersion, f2, ue2, ec2, o2);
		
		PersistenceUtil.persist(row);
		PersistenceUtil.persist(row2);
		
		List<TableRow> expected = new ArrayList<TableRow>();
		expected.add(row);
		expected.add(row2);
		
		List<TableRow> result = queryBaseData.findAllRows();
			
		PersistenceUtil.remove(row);
		PersistenceUtil.remove(row2);
		
		PersistenceUtil.remove(f);
		PersistenceUtil.remove(ue);
		PersistenceUtil.remove(ec);
		PersistenceUtil.remove(o);
		PersistenceUtil.remove(f2);
		PersistenceUtil.remove(ue2);
		PersistenceUtil.remove(ec2);
		PersistenceUtil.remove(o2);
		
		assertNotNull(result);
		assertEquals(expected.size(), result.size());
		
	}

}
