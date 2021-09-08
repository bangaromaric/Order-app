package ga.banga.commande.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_client")
@DiscriminatorValue("Client")
abstract class Client(
    @Id
    @GeneratedValue
    private var id: Long,
    private var nom: String = "",
    private var adresse: String = "",
    private var mail: String = ""
) : Serializable {


    companion object {
        private const val serialVersionUID = 1L
    }
}