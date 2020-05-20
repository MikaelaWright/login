package org.mikaela;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void validation_userNameAndPasswordMatch_Success() {
        //Arrange
        String userName = "mika";
        String password = "snoopy12";

        //Act
        UserService.register(userName, password);
        boolean entered = UserService.lookup(userName, password);

        //Assert
        Assert.assertTrue(entered);
        // delete contents
    }

    @Test
    public void validation_userNameMatchesPasswordNot_Fail() {
        Assert.assertFalse(UserService.lookup("mika", "wrong"));
    }

    @Test
    public void validation_userNameDoesNotMatchesPasswordDoes_Fail() {
        boolean entered = UserService.lookup("mika123", "snoopy12");
        Assert.assertFalse(entered);
    }

    @Test
    public void validation_emptyPassword_Fail() {
        boolean entered = UserService.lookup("mika123", null);
        Assert.assertFalse(entered);
    }

    @Test
    public void validation_nullUserName_Fail() {
        boolean entered = UserService.lookup(null, "snoopy12");
        Assert.assertFalse(entered);
    }

    @Test
    public void validation_emptyUserName_Fail() {
        boolean entered = UserService.lookup("", "snoopy12");
        Assert.assertFalse(entered);
    }
}
