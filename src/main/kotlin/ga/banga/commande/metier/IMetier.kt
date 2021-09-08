package ga.banga.commande.metier

import ga.banga.commande.entities.*
import java.util.*

interface IMetier {
    fun insertParticulier(particulier: Particulier): Particulier
    fun findAllParticuliers(): Collection<Particulier>
    fun findParticulierById(id: Long): Optional<Particulier>
    fun findAllClients(): Collection<Client>
    fun findClientById(id: Long): Optional<Client>
    fun insertSociete(societe: Societe): Societe
    fun findAllSocietes(): Collection<Societe>
    fun findSocieteById(id: Long): Optional<Societe>
    fun insertProduit(produit: Produit): Produit
    fun findAllProduits(): Collection<Produit>
    fun findProduitById(id: Long): Optional<Produit>
    fun insertCommande(commande: Commande): Commande
    fun findAllCommandes(): Collection<Commande>
    fun findCommandeById(id: Long): Optional<Commande>
    fun insertLigneCommand(ligneCommands: LigneCommands): LigneCommands
    fun findAllLigneCommands(): Collection<LigneCommands>
    fun findLigneCommandsById(id: Long): Optional<LigneCommands>
}