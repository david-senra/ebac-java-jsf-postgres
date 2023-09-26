package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.IProdutoDao;
import domain.Produto;
import exceptions.DaoException;

@Stateless
public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {
	
	@Inject
    public ProdutoService(IProdutoDao produtoDao) {
        super(produtoDao);
    }

    @Override
    public Produto buscarPorCodigo(Long codigo) throws DaoException {
        return this.dao.consultar(codigo);
    }

}
