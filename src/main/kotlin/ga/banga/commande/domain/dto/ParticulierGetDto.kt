package ga.banga.commande.domain.dto

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class ParticulierGetDto(val id: Long, val nom: String, val adresse: String, val mail: String)
