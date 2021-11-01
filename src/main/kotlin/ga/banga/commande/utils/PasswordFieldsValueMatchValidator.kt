package ga.banga.commande.utils

import javax.validation.ConstraintValidator
import ga.banga.commande.annotation.PasswordValueMatch
import javax.validation.ConstraintValidatorContext
import org.springframework.beans.BeanWrapperImpl

class PasswordFieldsValueMatchValidator : ConstraintValidator<PasswordValueMatch, Any?> {
    private var field: String? = null
    private var fieldMatch: String? = null
    private var message: String? = null
    override fun initialize(constraintAnnotation: PasswordValueMatch) {
        field = constraintAnnotation.field
        fieldMatch = constraintAnnotation.fieldMatch
        message = constraintAnnotation.message
    }

    override fun isValid(
        value: Any?,
        context: ConstraintValidatorContext
    ): Boolean {
        val fieldValue = BeanWrapperImpl(value!!)
            .getPropertyValue(field!!)
        val fieldMatchValue = BeanWrapperImpl(value)
            .getPropertyValue(fieldMatch!!)!!
        var isValid = false
        if (fieldValue != null) {
            isValid = fieldValue == fieldMatchValue
        }
        if (!isValid) {
            context.disableDefaultConstraintViolation()
            context
                .buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation()
            context
                .buildConstraintViolationWithTemplate(message)
                .addPropertyNode(fieldMatch)
                .addConstraintViolation()
        }
        return isValid
    }
}