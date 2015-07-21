package com.mfhsapp.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mfhsapp.test.enums.AttributeType;
import com.mfhsapp.test.enums.OptionType;
import com.mfhsapp.test.enums.Status;
import com.mfhsapp.test.enums.UserRole;
import com.mfhsapp.test.model.Address;
import com.mfhsapp.test.model.Attribute;
import com.mfhsapp.test.model.BrokerBorrower;
import com.mfhsapp.test.model.Contact;
import com.mfhsapp.test.model.Lender;
import com.mfhsapp.test.model.LoanTemplate;
import com.mfhsapp.test.model.Option;
import com.mfhsapp.test.model.OptionContainer;
import com.mfhsapp.test.model.User;
import com.mfhsapp.test.service.BrokerBorrowerService;
import com.mfhsapp.test.service.LenderService;
import com.mfhsapp.test.service.LoanTemplateService;
import com.mfhsapp.test.service.UserService;

public class App {
	public static void main(String[] args) {
		System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Option o1= new Option();
		o1.setName("Flag");
		o1.setOptionType(OptionType.CHECK_UNCHECK);
		o1.setIsChecked(true);
		o1.setStatus(Status.ACTIVE);
		Option o2= new Option();
		o2.setName("Unflag");
		o2.setOptionType(OptionType.CHECK_UNCHECK);
		o2.setIsChecked(false);
		o2.setStatus(Status.ACTIVE);

		Option o3= new Option();
		o3.setName("22");
		o3.setOptionType(OptionType.SINGLE_NUM_VALUED);
		o3.setNumValue1(new BigDecimal(22));
		o3.setStatus(Status.ACTIVE);

		Option o4= new Option();
		o4.setName("45");
		o4.setOptionType(OptionType.SINGLE_NUM_VALUED);
		o4.setNumValue1(new BigDecimal(45));
		o4.setStatus(Status.ACTIVE);


		OptionContainer oc1 = new OptionContainer();
		oc1.setName("Hotels");
		oc1.setOptionsList(new HashSet<Option>(Arrays.asList(o1,o2 )));

		OptionContainer oc2 = new OptionContainer();
		oc2.setName("oc2");
		oc2.setOptionsList(new HashSet<Option>(Arrays.asList(o3)));
		OptionContainer oc3 = new OptionContainer();
		oc3.setName("oc3");
		oc3.setOptionsList(new HashSet<Option>(Arrays.asList(o4)));

		Attribute a1= new Attribute();
		a1.setName("Property type");
		a1.setAttributeType(AttributeType.LENDER_CHECK_UNCHECK_AND_BB_RADIO);
		a1.setOptionContainerList(new HashSet<OptionContainer>(Arrays.asList(oc1)));
		a1.setStatus(Status.ACTIVE);

		Attribute a2= new Attribute();
		a2.setName("AGE");
		a2.setAttributeType(AttributeType.LENDER_CHECK_UNCHECK_AND_BB_RADIO);
		a2.setOptionContainerList(new HashSet<OptionContainer>(Arrays.asList(oc2,oc3)));
		a2.setStatus(Status.ACTIVE);

		LoanTemplate lt =new LoanTemplate();
		lt.setAttributeList(new HashSet<Attribute>(Arrays.asList(a1,a2)));
		lt.setName("HOMELOAN");
		lt.setStatus(Status.ACTIVE);

		LoanTemplateService ltService = (LoanTemplateService) context.getBean("loanTemplateService");
		ltService.persistCriteria(lt);


		Contact c=newContact();

		User u=newUser(c);
		/////////////////////////

		BrokerBorrower bb= new BrokerBorrower();
		bb.setName("Broker Decosta");
		bb.setDec("the first Broker ever");
		bb.setStatus(Status.ACTIVE);

		//set users
		/*User u1= newUser(u.getUserContact());
		u1.setUsername("UserBorrower1");
		u1.getUserContact().setEmail1("tom1@Decosta.com");
		u1.getUserContact().setFirstName("Decosta1");

		User u2= newUser(u.getUserContact());
		u2.setUsername("UserBorrower2");
		u2.getUserContact().setEmail1("tom2@Decosta.com");
		u2.getUserContact().setFirstName("Decosta2");*/

		bb.setUsers(new HashSet<User>(Arrays.asList(u )));
		//set contacts
		/*Contact c1= newContact();
		Contact c2= newContact();
		c1.setFirstName("C1Fname");
		Address a1=c1.getContactAddress();
		Address a2=c1.getContactAddress();
		a1.setAddressLine1("32501 Quene street");
		a2.setAddressLine2("5555 tomtom street");
		c1.setContactAddress(a1);
		c2.setFirstName("C2Fname");
		c2.setContactAddress(a2);*/

		bb.setContacts(new HashSet<Contact>(Arrays.asList(c )));

		runBBtest(bb,context);

		/////////////////////////

		//runUsertest(u,context);

		//Lender l=newLender(u);
		//runLendertest(l,context);

		//BrokerBorrower bb=newBB(u);
		//runBBtest(bb,context);


		context.close();
	}
	private static void runBBtest(BrokerBorrower bb,ConfigurableApplicationContext context){
		BrokerBorrowerService bbService = (BrokerBorrowerService) context.getBean("brokerBorrowerService");
		bbService.persistBrokerBorrower(bb);

		BrokerBorrower b=bbService.findBrokerBorrowerById(new BigInteger("1"));
		System.out.println("dec="+b.getDec() +"\n"+
				"pass="+b.getName() +"\n");// +lender.getContacts().size());

		for (User u : b.getUsers()) {
			System.out.println("uname="+u.getUsername() +"\n"+
					"pass="+u.getPassword() +"\n"+
					"EMAILID1="+u.getUserContact().getEmail1() +"\n"+
					"USERNAME="+u.getUsername() +"\n"+
					"FNAme="+u.getUserContact().getFirstName() +"\n"+
					"ADDLine1="+u.getUserContact().getContactAddress().getAddressLine1() +"\n"+
					"ADDCity="+u.getUserContact().getContactAddress().getCity() +"\n");
		}
		for (Contact newC : b.getContacts()) {
			System.out.println("EMAILID1="+newC.getEmail1() +"\n"+
					"EMAILID2="+newC.getEmail2() +"\n"+
					"FNAme="+newC.getFirstName() +"\n"+
					"ADDLine1="+newC.getContactAddress().getAddressLine1() +"\n"+
					"ADDCity="+newC.getContactAddress().getCity() +"\n");
		}


	}

	private static BrokerBorrower newBB(User u){
		BrokerBorrower bb= new BrokerBorrower();
		bb.setName("Broker Decosta");
		bb.setDec("the first Broker ever");
		bb.setStatus(Status.ACTIVE);

		//set users
		User u1= newUser(u.getUserContact());
		u1.setUsername("UserBorrower1");
		u1.getUserContact().setEmail1("tom1@Decosta.com");
		u1.getUserContact().setFirstName("Decosta1");

		User u2= newUser(u.getUserContact());
		u2.setUsername("UserBorrower2");
		u2.getUserContact().setEmail1("tom2@Decosta.com");
		u2.getUserContact().setFirstName("Decosta2");

		bb.setUsers(new HashSet<User>(Arrays.asList(u1,u2 )));
		//set contacts
		Contact c1= newContact();
		Contact c2= newContact();
		c1.setFirstName("C1Fname");
		Address a1=c1.getContactAddress();
		Address a2=c1.getContactAddress();
		a1.setAddressLine1("32501 Quene street");
		a2.setAddressLine2("5555 tomtom street");
		c1.setContactAddress(a1);
		c2.setFirstName("C2Fname");
		c2.setContactAddress(a2);

		bb.setContacts(new HashSet<Contact>(Arrays.asList(c1,c2 )));


		return bb;

	}

	private static void runLendertest(Lender l,ConfigurableApplicationContext context){
		LenderService lenderService = (LenderService) context.getBean("lenderService");
		lenderService.persistLender(l);

		Lender lender=lenderService.findLenderById(new BigInteger("1"));
		System.out.println("dec="+lender.getDec() +"\n"+
				"pass="+lender.getName() +"\n");// +lender.getContacts().size());

		for (User u : lender.getUsers()) {
			System.out.println("uname="+u.getUsername() +"\n"+
					"pass="+u.getPassword() +"\n"+
					"EMAILID1="+u.getUserContact().getEmail1() +"\n"+
					"USERNAME="+u.getUsername() +"\n"+
					"FNAme="+u.getUserContact().getFirstName() +"\n"+
					"ADDLine1="+u.getUserContact().getContactAddress().getAddressLine1() +"\n"+
					"ADDCity="+u.getUserContact().getContactAddress().getCity() +"\n");
		}
		for (Contact newC : lender.getContacts()) {
			System.out.println("EMAILID1="+newC.getEmail1() +"\n"+
					"EMAILID2="+newC.getEmail2() +"\n"+
					"FNAme="+newC.getFirstName() +"\n"+
					"ADDLine1="+newC.getContactAddress().getAddressLine1() +"\n"+
					"ADDCity="+newC.getContactAddress().getCity() +"\n");
		}


	}

	private static Lender newLender(User u){
		Lender l= new Lender();
		l.setName("LenderABC");
		l.setDec("the first lender ever");
		l.setStatus(Status.ACTIVE);

		//set users
		User u1= newUser(u.getUserContact());
		u1.setUsername("Manoj");
		u1.getUserContact().setEmail1("mbora@usc.edu");

		l.setUsers(new HashSet<User>(Arrays.asList(u,u1 )));
		//set contacts
		Contact c1= newContact();
		Contact c2= newContact();
		c1.setFirstName("C1Fname");
		Address a1=c1.getContactAddress();
		Address a2=c1.getContactAddress();
		a1.setAddressLine1("300021 Quene street");
		a2.setAddressLine2("555 tomtom street");
		c1.setContactAddress(a1);
		c2.setFirstName("C2Fname");
		c2.setContactAddress(a2);

		l.setContacts(new HashSet<Contact>(Arrays.asList(c1,c2 )));
		return l;

	}

	private static User newUser(Contact c){
		User user= new User();
		user.setPassword("password");
		user.setUsername("username");
		user.setStatus(Status.ACTIVE);
		user.setUserRole(UserRole.LENDER);
		user.setUserContact(c);
		return user;
	}

	private static void runUsertest(User user,ConfigurableApplicationContext context){

		UserService userService = (UserService) context.getBean("userService");
		userService.persistUser(user);

		User u=userService.findUserById(new BigInteger("1"));
		System.out.println("uname="+u.getUsername() +"\n"+
				"pass="+u.getPassword() +"\n"+
				"EMAILID1="+u.getUserContact().getEmail1() +"\n"+
				"EMAILID2="+u.getUserContact().getEmail2() +"\n"+
				"FNAme="+u.getUserContact().getFirstName() +"\n"+
				"ADDLine1="+u.getUserContact().getContactAddress().getAddressLine1() +"\n"+
				"ADDCity="+u.getUserContact().getContactAddress().getCity() +"\n");

	}


	private static Contact newContact(){
		Address a = new Address();
		a.setAddressLine1("897 waynelomsom place");
		a.setAddressLine2("apt 1");
		a.setCity("San Francisco");
		a.setZipcode("94133");
		a.setState("CA");


		Contact c = new Contact();
		c.setContactAddress(a);
		c.setEmail1("abc@bcd.com");
		c.setEmail2("efg@bcd.com");
		c.setFirstName("Mike");
		c.setLastName("Tom");
		c.setPhone1("123456789");
		c.setPhone2("5555555555");
		c.setPreferedTime("8:00Am to 9:00 Pm");
		c.setStatus(Status.ACTIVE);
		return c;
	}
}
