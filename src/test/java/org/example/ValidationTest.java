package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.dto.PageInfo;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ValidationTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nameIsNull() {
        PageInfo pageInfo = new PageInfo( null, "DD-AB-123");

        Set<ConstraintViolation<PageInfo>> constraintViolations = validator.validate( pageInfo );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void nameTooShort() {
        PageInfo pageInfo = new PageInfo( "a", "DD-AB-123");

        Set<ConstraintViolation<PageInfo>> constraintViolations = validator.validate( pageInfo );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "size must be between 2 and 14",
                constraintViolations.iterator().next().getMessage()
        );
    }
}
