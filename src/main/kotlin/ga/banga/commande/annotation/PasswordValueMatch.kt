package ga.banga.commande.annotation

import ga.banga.commande.utils.PasswordFieldsValueMatchValidator
import kotlin.reflect.KClass
import javax.validation.Payload
import javax.validation.Constraint

/**
 * <h2>PasswordValueMatch</h2>
 *
 * @author aek
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@kotlin.annotation.Retention(
    AnnotationRetention.RUNTIME
)
@Constraint(validatedBy = [PasswordFieldsValueMatchValidator::class])
@MustBeDocumented
annotation class PasswordValueMatch(
    val message: String = "Fields values don't match!",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val field: String,
    val fieldMatch: String
) {
    @Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
    @kotlin.annotation.Retention(
        AnnotationRetention.RUNTIME
    )
    annotation class List(vararg val value: PasswordValueMatch)
}