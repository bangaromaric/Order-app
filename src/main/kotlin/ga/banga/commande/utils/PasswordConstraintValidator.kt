package ga.banga.commande.utils

import javax.validation.ConstraintValidator
import ga.banga.commande.annotation.ValidPassword
import org.passay.*
import java.util.*
import javax.validation.ConstraintValidatorContext
import java.util.stream.Collectors

class PasswordConstraintValidator : ConstraintValidator<ValidPassword?, String?> {
    override fun initialize(constraintAnnotation: ValidPassword?) {
        super.initialize(constraintAnnotation)
    }

    override fun isValid(password: String?, context: ConstraintValidatorContext): Boolean {
        val validator = PasswordValidator(
            Arrays.asList( // at least 8 characters
                LengthRule(8, 100),  // at least one upper-case character
                //                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                // at least one lower-case character
                //                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                // at least one digit character
                //                new CharacterRule(EnglishCharacterData.Digit, 1),
                // at least one symbol (special character)
                //                new CharacterRule(EnglishCharacterData.Special, 1),
                // no whitespace
                WhitespaceRule()
            )
        )
        val result = validator.validate(PasswordData(password))
        if (result.isValid) {
            return true
        }
        val messages = validator.getMessages(result)
        val messageTemplate = messages.stream()
            .collect(Collectors.joining(","))
        context.buildConstraintViolationWithTemplate(messageTemplate)
            .addConstraintViolation()
            .disableDefaultConstraintViolation()
        return false
    }
}