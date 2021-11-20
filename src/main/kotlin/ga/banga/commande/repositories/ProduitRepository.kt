package ga.banga.commande.repositories

import ga.banga.commande.entities.Produit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProduitRepository : JpaRepository<Produit, Long>