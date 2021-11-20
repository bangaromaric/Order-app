package ga.banga.commande.domain.mapper

import ga.banga.commande.domain.dto.ParticulierGetDto
import ga.banga.commande.domain.dto.ParticulierPostDto
import ga.banga.commande.domain.dto.SocieteGetDto
import ga.banga.commande.entities.Particulier
import ga.banga.commande.entities.Societe
import org.mapstruct.Mapper

@Mapper(
    componentModel = "spring"
)
interface MapStructMapper {

    fun societeToSocieteGetDto(societe: Societe): SocieteGetDto
    fun societeAllToSocieteGetDto(societe: Collection<Societe>): Collection<SocieteGetDto>
    fun particToParticGetDto(particuler: Particulier): ParticulierGetDto
    fun particAllToParticAllGetDto(particuler: Collection<Particulier>): Collection<ParticulierGetDto>
    fun particulierPostDtoToParticulier(particulierPostDto: ParticulierPostDto): Particulier

}