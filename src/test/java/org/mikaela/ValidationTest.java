package org.mikaela;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    public void validation_userNameAndPasswordMatch_Success() {
        //Arrange
        String userName = "mika";
        String password = "snoopy12";

        //Act
        boolean entered = Validation.validation(userName, password);

        //Assert
        Assert.assertTrue(entered);
    }

    @Test
    public void validation_userNameMatchesPasswordNot_Fail() {
        Assert.assertFalse(Validation.validation("mika", "wrong"));
    }

    @Test
    public void validation_userNameDoesNotMatchesPasswordDoes_Fail() {
        boolean entered = Validation.validation("mika123", "snoopy12");
        Assert.assertFalse(entered);
    }

    @Test
    public void validation_emptyPassword_Fail() {
        boolean entered = Validation.validation("mika123", null);
        Assert.assertFalse(entered);
    }

    @Test
    public void validation_nullUserName_Fail() {
        boolean entered = Validation.validation(null, "snoopy12");
        Assert.assertFalse(entered);
    }

    @Test
    public void validation_emptyUserName_Fail() {
        boolean entered = Validation.validation("", "snoopy12");
        Assert.assertFalse(entered);
    }
}
