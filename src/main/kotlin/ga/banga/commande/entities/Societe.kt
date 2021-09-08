package ga.banga.commande.entities

import java.io.Serializable
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("Societe")
data class Societe(val id: Long, val nom: String, val adresse: String, val mail: String, val matriculeFinance: String) :
    Client(id, nom, adresse, mail), Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }
}