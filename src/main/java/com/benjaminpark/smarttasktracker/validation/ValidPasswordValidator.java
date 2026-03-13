package com.benjaminpark.smarttasktracker.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {


        if (s.length() < 8) {
            return false;
        }

        if (s.length() > 16) {
            return false;
        }

        if (s.length() != s.trim().length()) {
            return false;
        }

        Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(s);

        if (!m.find()) {
            return false;
        }

        if (!s.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }
}
