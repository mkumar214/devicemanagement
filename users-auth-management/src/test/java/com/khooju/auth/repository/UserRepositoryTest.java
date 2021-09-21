package com.khooju.auth.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.khooju.auth.db.model.LoginHistory;
import com.khooju.auth.db.model.UserProfile;
import com.khooju.auth.db.model.Users;

@ExtendWith(SpringExtension.class)
@DataJpaTest
/*
 * @TestPropertySource(properties = { "spring.jpa.hibernate.ddl-auto=update" })
 */
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserProfileRepo profileRepo;

	@Autowired
	private LoginHistoryRepo historyRepo;
	
	@Test
	public void savedUserTestCase() {
		Users testUser = new Users();
		testUser.setUsername("testUser");
		testUser.setPassword("Password@1");
		testUser.setContactNumber("9205050564");
		testUser.setEmailid("mail@mail.com");
		
		Users testUser_1 = userRepo.save(testUser);
		 assertEquals("testUser",testUser_1.getUsername());
		 
		 Users testUser_2 = new Users();
			testUser_2.setUsername("testUser2");
			testUser_2.setPassword("Password@1");
			testUser_2.setContactNumber("9205050564");
			testUser_2.setEmailid("mail@mail.com");
			
			Users savedUser_2 = userRepo.save(testUser_2);
			assertEquals("testUser2", savedUser_2.getUsername());
		
	}
	
	@Test
	public void savedUserProfileTest() {
		Users testUser = new Users();
		testUser.setUsername("testUser");
		testUser.setPassword("Password@1");
		testUser.setContactNumber("9205050564");
		testUser.setEmailid("mail@mail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setdOB(new Date());
		userProfile.setFirstName("testFirstName");
		userProfile.setLastName("testLastName");
		userProfile.setGender("male");
		userProfile.setUser(testUser);
		
		UserProfile savedUserProfile = profileRepo.save(userProfile);
		assertNotNull(savedUserProfile);
	}
	
	@Test
	public void saveLoginHistoryTest() {
		Users testUser = new Users();
		testUser.setUsername("testUser");
		testUser.setPassword("Password@1");
		testUser.setContactNumber("9205050564");
		testUser.setEmailid("mail@mail.com");
		
		LoginHistory testLoginHistory = new LoginHistory();
		
		testLoginHistory.setDevice("android");
		testLoginHistory.setActiveDevice(false);
		testLoginHistory.setLastPasswordChange(new Date());
		testLoginHistory.setLastSuccessFullLogin(new Date());
		testLoginHistory.setUser(testUser);
		
		LoginHistory savedLoginHistory = historyRepo.save(testLoginHistory);
		assertNotNull(savedLoginHistory);
	}
	
}
