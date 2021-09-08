package ga.banga.commande.entities

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
//@Data
data class Produit(
    @Id
    @GeneratedValue
    var id: Long = 0,
    var designation: String = "",
    var unite: Unite = Unite.G,
    var poidsUnitaire: Int = 0,
    var prixUnitaire: Double = 0.0
) : Serializable {


    //    @OneToMany(mappedBy = "produit")
    //    private Set<LigneCommands> ligneCommande;

}