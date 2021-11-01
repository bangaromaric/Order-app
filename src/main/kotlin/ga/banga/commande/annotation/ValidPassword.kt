package ga.banga.commande.annotation

import ga.banga.commande.utils.PasswordConstraintValidator
import javax.validation.Constraint
import kotlin.reflect.KClass
import javax.validation.Payload

@MustBeDocumented
@Constraint(validatedBy = [PasswordConstraintValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@kotlin.annotation.Retention(
    AnnotationRetention.RUNTIME
)
annotation class ValidPassword(
    val message: String = "Invalid Password",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)