package com.uniservice.service;

import com.uniservice.entity.User;
import com.uniservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User("1", "John Doe", "1234567890");
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testUpdateUser() {
        User user = new User("1", "John Doe", "1234567890");
        User updatedDetails = new User("1", "Jane Doe", "0987654321");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(updatedDetails);

        User updatedUser = userService.updateUser("1", updatedDetails);

        assertNotNull(updatedUser);
        assertEquals("Jane Doe", updatedUser.getName());
        assertEquals("0987654321", updatedUser.getPhoneNumber());
        verify(userRepository, times(1)).findById("1");
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("1", "John Doe", "1234567890");
        User user2 = new User("2", "Jane Doe", "0987654321");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertNotNull(users);
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById() {
        User user = new User("1", "John Doe", "1234567890");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById("1");

        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
        verify(userRepository, times(1)).findById("1");
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById("1");

        userService.deleteUser("1");

        verify(userRepository, times(1)).deleteById("1");
    }
}