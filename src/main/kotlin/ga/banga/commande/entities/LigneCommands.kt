package ga.banga.commande.entities

import java.io.Serializable
import javax.persistence.*

@Entity
//@Data
data class LigneCommands(
    @Id
    @GeneratedValue
    val id: Long = 0,
    @ManyToOne
    var produit: Produit,

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
    @ManyToOne(cascade = [CascadeType.ALL])
    val commande: Commande,

    val quatite: Int = 0

) : Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }

    override fun toString(): String {
        return "LigneCommands(id=$id, quatite=$quatite)"
    }


}