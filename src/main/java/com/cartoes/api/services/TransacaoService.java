package com.cartoes.api.services;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.cartoes.api.entities.Cliente;
import com.cartoes.api.repositories.ClienteRepository;
import com.cartoes.api.entities.Cartao;
import com.cartoes.api.repositories.CartaoRepository;
import com.cartoes.api.repositories.TransacaoRepository;
import com.cartoes.api.utils.ConsistenciaException;

@Service
public class TransacaoService {
	private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public Optional<Cartao> buscarPorId(String numero) throws ConsistenciaException {

		public Optional<Cartao> buscarPorId(int id) throws ConsistenciaException {
			log.info("Service: buscando os cartoes de numero: {}", numero);
			Optional<Cartao> cartao = cartaoRepository.findById(id);
			if (!cartao.isPresent()) {
				log.info("Service: Nenhum cartão de número: {} foi encontrado", numero);
				throw new ConsistenciaException("Nenhum cartão de número: {} foi encontrado", numero);
			}
			return cartao;
		}
	}