package com.forum.hub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> detalhar(Long id) {
        return topicoRepository.findById(id);
    }

    @Transactional
    public Topico criar(Topico topico) {
        if (topicoRepository.existsByTituloAndMensagem(topico.getTitulo(), topico.getMensagem())) {
            throw new IllegalArgumentException("Tópico duplicado");
        }
        return topicoRepository.save(topico);
    }

    @Transactional
    public Topico atualizar(Long id, Topico topicoAtualizado) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isEmpty()) {
            throw new IllegalArgumentException("Tópico não encontrado");
        }

        Topico topico = optionalTopico.get();
        topico.setTitulo(topicoAtualizado.getTitulo());
        topico.setMensagem(topicoAtualizado.getMensagem());
        topico.setEstado(topicoAtualizado.getEstado());
        topico.setCurso(topicoAtualizado.getCurso());
        topico.setAutor(topicoAtualizado.getAutor());

        return topicoRepository.save(topico);
    }

    @Transactional
    public void deletar(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tópico não encontrado");
        }
    }
}