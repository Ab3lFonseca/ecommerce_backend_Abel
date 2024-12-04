package senac.PFHtml.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Produto> get(
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "order", required = false) String order,
            @RequestParam(value = "filter", required = false) String filter) {
 
        // Configura a ordenação
        Sort sort = Sort.unsorted(); // Sem ordenação por padrão
        if (sortBy != null && order != null) {
            sort = order.equalsIgnoreCase("desc")
                    ? Sort.by(sortBy).descending()
                    : Sort.by(sortBy).ascending();
        }
 
        // Retorna os produtos filtrados e ordenados, ou todos os produtos se o filtro não for informado
        if (filter != null && !filter.isEmpty()) {
            return repository.findByNomeContains(filter, sort);
        }
 
        // Retorna todos os produtos com a ordenação especificada
        return repository.findAll(sort);
    }
 
    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }
}
   
 