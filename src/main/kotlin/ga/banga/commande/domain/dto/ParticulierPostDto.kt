package ga.banga.commande.domain.dto



import ga.banga.commande.annotation.PasswordValueMatch
import ga.banga.commande.annotation.ValidPassword
import javax.validation.constraints.*


@PasswordValueMatch.List(
    PasswordValueMatch(
        field = "password",
        fieldMatch = "rePassword",
        message = "Les mots de passe sont different"
    )

)
data class ParticulierPostDto(@field:NotEmpty(message = "Ce champ ne doit pas etre vide") val nom: String="",
                              @field:NotEmpty(message = "Ce champ ne doit pas etre vide") val adresse: String="",
                              @field:NotEmpty(message = "Ce champ ne doit pas etre vide")
                              @field:Email(message = "l'email n'est pas au bon format") val mail: String="",
                              @field:NotEmpty(message = "Confirm Password is mandatory")
                              @field:ValidPassword var password: String="",
                              @field:NotBlank(message = "Confirm Password is mandatory") var rePassword: String="") {

}
