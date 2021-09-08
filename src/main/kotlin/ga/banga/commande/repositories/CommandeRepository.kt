package ga.banga.commande.repositories

import ga.banga.commande.entities.Commande
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommandeRepository : JpaRepository<Commande, Long>