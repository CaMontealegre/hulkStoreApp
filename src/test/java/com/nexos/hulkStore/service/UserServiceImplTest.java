/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.hulkStore.service;

import com.nexos.hulkStore.domain.User;
import com.nexos.hulkStore.repository.UserRepository;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Carlos Montealegre
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    public UserServiceImpl userServiceImpl;

    @Mock
    public UserService userService;

    @Mock
    public UserRepository userRepository;

    public UserServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllUser method, of class UserServiceImpl.
     */
    @Test
    public void testGetAllUser() {
        assertNotNull(userServiceImpl.getAllUser());
    }

    /**
     * Test of createUser method, of class UserServiceImpl.
     */
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId("1234");
        user.setName("test");
        user.setEmail("test@gmail.com");
        user.setPass("1234");
        user.setRol("1");
        assertNull(userServiceImpl.createUser(user));
    }

    /**
     * Test of getAllUserById method, of class UserServiceImpl.
     */
    @Test
    public void testGetAllUserById() {
        User user = new User();
        user.setId("004");
        User userResponse = userServiceImpl.getAllUserById(user.getId());
        assertEquals(user, userResponse);
    }

    /**
     * Test of deleteUser method, of class UserServiceImpl.
     */
    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setId("004");
        userServiceImpl.deleteUser(user.getId());
    }

    /**
     * Test of editUser method, of class UserServiceImpl.
     */
    @Test
    public void testEditUser() {
        User user = new User();
        user.setId("1234");
        user.setName("test");
        user.setEmail("test@gmail.com");
        user.setPass("1234");
        user.setRol("1");
        userServiceImpl.getAllUserById(user.getId());
        User response = userServiceImpl.editUser(user);
        assertNull(response);
    }
}
