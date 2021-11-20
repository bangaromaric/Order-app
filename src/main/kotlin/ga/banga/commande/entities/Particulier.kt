package ga.banga.commande.entities

import java.io.Serializable
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@DiscriminatorValue("Particulier")
data class Particulier(var id: Long = 0, var nom: String = "", var adresse: String = "", var mail: String = ""
                       , var password: String ="") :
    Client(id, nom, adresse, mail,password), Serializable {


    companion object {
        private const val serialVersionUID = 1L
    }
}
