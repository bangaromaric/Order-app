package ga.banga.commande.entities

import lombok.EqualsAndHashCode
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
//@Data
data class Commande(
    @Id
    @GeneratedValue
    var id: Long = 0,
    var date: Date = Date(),
    var remise: Int = 0,
    var montant: Double = 0.0,
    @ManyToOne
    var client: Client,
//


) : Serializable {

    @EqualsAndHashCode.Exclude
//                    @ToString.Exclude
    @OneToMany(mappedBy = "commande")
    private val ligneCommande: Set<LigneCommands>? = null

    companion object {
        private const val serialVersionUID = 1L
    }

    override fun toString(): String {
        return "Commande(id=$id, date=$date, remise=$remise, montant=$montant, client=$client)"
    }
}