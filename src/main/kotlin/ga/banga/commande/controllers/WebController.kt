package ga.banga.commande.controllers

import ga.banga.commande.entities.*
import ga.banga.commande.metier.MetierImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class WebController {
    @Autowired
    lateinit var metier: MetierImpl
    
    @GetMapping("/")
    fun home(model: Model): String {
        val part: Collection<Particulier> = metier.findAllParticuliers()
        model.addAttribute("particuliers", part)
        return "index"
    }
    @GetMapping("/offline")
    fun offline(model: Model): String {
        val part: Collection<Particulier> = metier.findAllParticuliers()
        model.addAttribute("particuliers", Particulier())
        return "offline"
    }

    @GetMapping("/societe")
    fun getSocietes(model: Model): String {
        val sos: Collection<Societe> = metier.findAllSocietes()
        model.addAttribute("societes", sos)
        return "client/societe"
    }

    @GetMapping("/produit")
    fun getProduits(model: Model): String {
        val result: Collection<Produit> = metier.findAllProduits()
        model.addAttribute("produits", result)
        return "produit/produit"
    }

    @GetMapping("/addProduit")
    fun addProduit(model: Model): String {
        model.addAttribute("produit", Produit())
        return "produit/addProduit"
    }

    @PostMapping("/addProduit")
    fun produitSubmit(@ModelAttribute produit: Produit, model: Model): String {
        metier.insertProduit(produit)
        return "redirect:/produit"
    }

    @GetMapping("/addClient")
    fun addParticulier(model: Model): String {
        model.addAttribute("client", Particulier())
        return "client/addClient"
    }

    @PostMapping("/addClient")
    fun particulierSubmit(
        @ModelAttribute particulier: Particulier,
        model: Model,
        @RequestParam type: String,
        @RequestParam mat: String
    ): String {
        return if (type == "1") {
            metier.insertParticulier(particulier)
            "redirect:/"
        } else {
            val societe = Societe(0,particulier.nom, particulier.adresse, particulier.mail, mat)
            metier.insertSociete(societe)
            "redirect:/societe"
        }
    }

    @GetMapping("/commandes")
    fun getLigneCommandes(model: Model): String {
        val result: Collection<LigneCommands> = metier.findAllLigneCommands()
        model.addAttribute("commandesLigne", result)
        return "commande/commandes"
    }

    @GetMapping("/addCommandes")
    fun addCommande(model: Model): String {
        model.addAttribute("produit", Produit())
        model.addAttribute("clients", metier.findAllClients())
        model.addAttribute("produits", metier.findAllProduits())
        return "commande/addCommande"
    }

    @PostMapping("/addCommandes")
    fun commandeSubmit(
        @ModelAttribute produit: Produit,
        client: Client,
        remise: String,
        quantite: String,
        model: Model
    ): String {
//        metier.insertProduit(produit);
        val cmd: Commande = metier.insertCommande(Commande(0,Date(), remise.toInt(), produit.prixUnitaire, client))
        metier.insertLigneCommand(LigneCommands(0,produit, cmd, quantite.toInt()))

        return "redirect:/commandes"
    }
}