package ga.banga.commande.entities

import java.io.Serializable
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("Particulier")
data class Particulier(var id: Long = 0, val nom: String = "", val adresse: String = "", val mail: String = "") :
    Client(id, nom, adresse, mail), Serializable {


    companion object {
        private const val serialVersionUID = 1L
    }
}