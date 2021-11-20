package ga.banga.commande.domain.dto

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class SocieteGetDto(val id: Long, val nom: String, val adresse: String, val mail: String, val matriculeFinance: String)
