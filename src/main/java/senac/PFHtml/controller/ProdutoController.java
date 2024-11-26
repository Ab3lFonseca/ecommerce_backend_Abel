package senac.PFHtml.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
import senac.PFHtml.Model.Produto;
import senac.PFHtml.repository.ProdutoRepository;



 
@RestController
@RequestMapping("/produto")
public class ProdutoController {
 
    @Autowired
    private ProdutoRepository repository;
 
    @GetMapping
    public List<Produto> get() {
        return repository.findAll();
    }    
 
    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }
   
}
 