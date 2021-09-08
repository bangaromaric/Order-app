package ga.banga.commande.repositories

import ga.banga.commande.entities.Societe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SocieteRepository : JpaRepository<Societe, Long>