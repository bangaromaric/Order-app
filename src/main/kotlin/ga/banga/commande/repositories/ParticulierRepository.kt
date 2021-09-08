package ga.banga.commande.repositories

import ga.banga.commande.entities.Particulier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticulierRepository : JpaRepository<Particulier, Long>