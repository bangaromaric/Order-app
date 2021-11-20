package ga.banga.commande.controllers

import ga.banga.commande.domain.dto.ParticulierPostDto
import ga.banga.commande.domain.dto.SocieteGetDto
import ga.banga.commande.domain.mapper.MapStructMapper
import ga.banga.commande.entities.*
import ga.banga.commande.metier.IMetier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import javax.validation.Valid

@Controller
class WebController {
    @Autowired
    lateinit var metier: IMetier

    @Autowired
    lateinit var mapstructMapper: MapStructMapper

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
        val sos: Collection<SocieteGetDto> = mapstructMapper.societeAllToSocieteGetDto(metier.findAllSocietes())
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
        model.addAttribute("client", ParticulierPostDto())
        return "client/addClient"
    }

    @PostMapping("/addClient")
    fun particulierSubmit(
        @Valid @ModelAttribute("client") particulierPostDto: ParticulierPostDto,
        result: BindingResult,
        model: Model,
        @RequestParam type: String,
        @RequestParam mat: String
    ): String {
        return if (result.hasErrors()) {
            "client/addClient"

        }else if(type == "1"){
                val particulier = mapstructMapper.particulierPostDtoToParticulier(particulierPostDto)
                metier.insertParticulier(particulier)
                "redirect:/"
            }
        else {
         val particulier = mapstructMapper.particulierPostDtoToParticulier(particulierPostDto)
            val societe = Societe(0,particulier.nom, particulier.adresse, particulier.mail, mat,"qwerty")
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
//        val cmd: Commande = metier.insertCommande(Commande(0, Date(), remise.toInt(), produit.prixUnitaire, client))
        val cmd = Commande(0, Date(), remise.toInt(), produit.prixUnitaire, client)
        metier.insertLigneCommand(LigneCommands(0,produit, cmd, quantite.toInt()))

        return "redirect:/commandes"
    }
}