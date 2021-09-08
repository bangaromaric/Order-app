package ga.banga.commande.repositories

import ga.banga.commande.entities.LigneCommands
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LigneCommandeRepository : JpaRepository<LigneCommands, Long>