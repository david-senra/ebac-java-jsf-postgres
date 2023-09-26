package services;

import domain.Cliente;
import exceptions.DaoException;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DaoException;
}
