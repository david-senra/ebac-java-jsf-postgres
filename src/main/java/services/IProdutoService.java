package services;

import domain.Produto;
import exceptions.DaoException;

public interface IProdutoService extends IGenericService<Produto, Long> {

	Produto buscarPorCodigo(Long codigo) throws DaoException;
}
