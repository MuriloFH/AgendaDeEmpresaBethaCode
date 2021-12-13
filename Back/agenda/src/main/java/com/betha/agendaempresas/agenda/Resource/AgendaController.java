package com.betha.agendaempresas.agenda.Resource;

import com.betha.agendaempresas.agenda.model.Agenda;
import com.betha.agendaempresas.agenda.model.Servico;
import com.betha.agendaempresas.agenda.repository.AgendaRepository;
import com.betha.agendaempresas.agenda.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository repository;

    @GetMapping
    public List<Agenda> getAgendamentoServico(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Agenda getAgendaId(@PathVariable(value = "id") Long agendaId) throws EntityNotFoundException {

        Agenda agendaFind = repository.findById(agendaId).orElseThrow(() -> new EntityNotFoundException("Agenda não encontrada :: " + agendaId));
        return agendaFind;
    }

    @PostMapping
    public Agenda create(@RequestBody Agenda agenda){
        return repository.save(agenda);
    }

    @PutMapping("/{id}")
    public Agenda update(@PathVariable(value = "id")Long serviçoId,@RequestBody Agenda agenda)throws EntityNotFoundException{
        Agenda agendaFind = repository.findById(serviçoId).orElseThrow(()-> new EntityNotFoundException("Serviço não encontrada: "+serviçoId));
        agendaFind.setId(agenda.getId());
        agendaFind.setBackgroundColor(agenda.getBackgroundColor());
        agendaFind.setTitle(agenda.getTitle());
        agendaFind.setTitulo(agenda.getTitulo());
        agendaFind.setEnd(agenda.getEnd());
        agendaFind.setStart(agenda.getStart());
        return repository.save(agendaFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id")Long agendaId) throws EntityNotFoundException{
        Agenda agendaFind = repository.findById(agendaId).orElseThrow(() -> new EntityNotFoundException(" com ID :: "+agendaId));
        repository.delete(agendaFind);
        return ResponseEntity.noContent().build();
    }
}
