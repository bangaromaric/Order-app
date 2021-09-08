package ga.banga.commande.metier

import ga.banga.commande.entities.*
import ga.banga.commande.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class MetierImpl : IMetier {

    @Autowired
     lateinit var  particulierRepository: ParticulierRepository

    @Autowired
    lateinit var societeRepository: SocieteRepository

    @Autowired
    lateinit var produitRepository: ProduitRepository

    @Autowired
    lateinit var commandeRepository: CommandeRepository

    @Autowired
    lateinit var ligneCommandeRepository: LigneCommandeRepository

    @Autowired
    lateinit var clientRepository: ClientRepository


    override fun insertParticulier(particulier: Particulier): Particulier {
        return particulierRepository.save(particulier)
    }

    override fun findAllParticuliers(): Collection<Particulier> {
      return  particulierRepository.findAll()
    }

    override fun findParticulierById(id: Long): Optional<Particulier> {
       return particulierRepository.findById(id)
    }

    override fun findAllClients(): Collection<Client> {
        return clientRepository.findAll()
    }

    override fun findClientById(id: Long): Optional<Client> {
        return Optional.empty<Client>()
    }

    override fun insertSociete(societe: Societe): Societe {
        return societeRepository.save(societe)
    }

    override fun findAllSocietes(): Collection<Societe> {
       return societeRepository.findAll()
    }



    override fun findSocieteById(id: Long): Optional<Societe> {
        return Optional.empty<Societe>()
    }

    override fun insertProduit(produit: Produit): Produit {
        return produitRepository.save(produit)
    }

    override fun findAllProduits(): Collection<Produit> {
        return produitRepository.findAll()
    }



    override fun findProduitById(id: Long): Optional<Produit> {
        return Optional.empty<Produit>()
    }

    override fun insertCommande(commande: Commande): Commande {
        return commandeRepository.save(commande)
    }

    override fun findAllCommandes(): Collection<Commande> {
        return commandeRepository.findAll()
    }


    override fun findCommandeById(id: Long): Optional<Commande> {
        return Optional.empty<Commande>()
    }

    override fun insertLigneCommand(ligneCommands: LigneCommands): LigneCommands {
        return ligneCommandeRepository.save(ligneCommands)
    }

    override fun findAllLigneCommands(): Collection<LigneCommands> {
      return  ligneCommandeRepository.findAll()
    }



    override fun findLigneCommandsById(id: Long): Optional<LigneCommands> {
        return Optional.empty<LigneCommands>()
    }
}