package dao;

import domain.Venda;
import exceptions.DaoException;

public interface IVendaDao {
    void finalizarVenda(Venda venda) throws DaoException;
    void cancelarVenda(Venda venda) throws DaoException;
    Venda consultarComCollection(Long id);
}
