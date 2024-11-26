package senac.PFHtml.repository;

import senac.PFHtml.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository
                 extends JpaRepository<Produto,Integer> {
    
}
