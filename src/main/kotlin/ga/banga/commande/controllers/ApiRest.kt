package ga.banga.commande.controllers

import ga.banga.commande.entities.*
import ga.banga.commande.metier.MetierImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("api/")
class ApiRest {

    @Autowired
    lateinit var metier: MetierImpl

    @GetMapping("clients")
    @CrossOrigin(origins = ["http://localhost:8080"])
    fun findClients() : Collection<Client>{
        val result: Collection<Client> = metier.findAllClients()
        return result.ifEmpty {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "entity not found"
            )
        }
    }


    @GetMapping("particuliers")
    fun findParticuliers(): Collection<Particulier>{
        val result: Collection<Particulier> = metier.findAllParticuliers()

        return result.ifEmpty {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "entity not found"
            )
        }
    }
    @PostMapping(value = ["particulier/add"])
    fun ajouterParticulier(@RequestBody particulier: Particulier): ResponseEntity<Particulier> {
        metier.insertParticulier(particulier)
        return ResponseEntity<Particulier>(particulier, HttpStatus.CREATED)
    }

    @PutMapping(value = ["particulier/update"])
    fun updateParticulier(
        @RequestBody newParticulier: Particulier,
        @RequestParam id: Long
    ): ResponseEntity<Particulier> {
        return metier.findParticulierById(id)
            .map { particulier ->
//                particulier = newParticulier
                newParticulier.id=id
                metier.insertParticulier(newParticulier)
                ResponseEntity.status(HttpStatus.ACCEPTED).body(particulier)
            }
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Particulier not found") }
    }


    @GetMapping("societes")
    fun findSocietes():Collection<Societe>{
        val result: Collection<Societe> = metier.findAllSocietes()

        return result.ifEmpty {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "entity not found"
            )
        }
    }




    @GetMapping(value = ["commande/add"])
    fun ajouterCommande( /*@RequestBody Particulier particulier*/): ResponseEntity<Particulier> {
        val particulier = Particulier(0,"Romaric BANGA", "Akebe", "bangaromaric@gmail.ga","qwertyui")
        val produit = Produit(0,"Pain", Unite.G, 1, 125.0)
        produit.id =5L
        particulier.id=1L

//      Set<LigneCommands> listLigneCommands = new HashSet<>();
//      LigneCommands ligneCommands = new LigneCommands(produit,cmd,2);
//      listLigneCommands.add(ligneCommands);
//      metier.insertLigneCommand(ligneCommands);
        val cmd: Commande = metier.insertCommande(Commande(0,Date(), 2, 200.0, particulier ))
        metier.insertLigneCommand(LigneCommands(0,produit, cmd, 2))
        return ResponseEntity<Particulier>(particulier, HttpStatus.CREATED)
    }


}