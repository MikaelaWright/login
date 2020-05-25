package org.mikaela;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    @Test
    public void register_existingUser_ErrorsNotEmpty() {
        //Arrange
        String userName = "mika";
        String password = "snoopy12";
        UserService.register(userName, password);

        //Act
        ArrayList<String> errors = UserService.register(userName, password);

        //Assert
        assertTrue(errors.size() != 0);
        System.out.println(errors.get(0));
    }

    @Test
    public void validation_userNameAndPasswordMatch_Success() {
        //Arrange
        String userName = "mika";
        String password = "snoopy12";

        //Act
        UserService.register(userName, password);
        boolean entered = UserService.lookup(userName, password);

        //Assert

        assertTrue(entered);
    }

    @Test
    public void retrieveAllUsers() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    public void validation_userNameMatchesPasswordNot_Fail() {
        //correct password: snoopy12
        assertFalse(UserService.lookup("mika", "wrong"));
    }

    @Test
    public void validation_userNameDoesNotMatchesPasswordDoes_Fail() {
        //correct username: mika

        boolean entered = UserService.lookup("mika123", "snoopy12");
        assertFalse(entered);
    }

    @Test
    public void validation_emptyPassword_Fail() {
        boolean entered = UserService.lookup("mika", null);
        assertFalse(entered);
    }

    @Test
    public void validation_nullUserName_Fail() {
        boolean entered = UserService.lookup(null, "snoopy12");
        assertFalse(entered);
    }

    @Test
    public void validation_emptyUserName_Fail() {
        boolean entered = UserService.lookup("", "snoopy12");
        assertFalse(entered);
    }
}
