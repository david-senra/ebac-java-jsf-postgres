package services;

import dao.IClienteDao;
import domain.Cliente;
import exceptions.DaoException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    @Inject
    public ClienteService(IClienteDao clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DaoException {
        return this.dao.consultar(cpf);
    }
}
