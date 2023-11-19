package com.micode.controller;

import com.micode.dto.ConsultDTO;
import com.micode.dto.ConsultListExamDTO;
import com.micode.model.Consult;
import com.micode.model.Exam;
import com.micode.service.IConsultService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/consults")
@RequiredArgsConstructor
public class ConsultController {

    //@Autowired
    private final IConsultService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ConsultDTO>> findAll(){
        List<ConsultDTO> list = service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultDTO> findById(@PathVariable("id") Integer id){
        ConsultDTO dto = this.convertToDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /*@PostMapping
    public ResponseEntity<ConsultDTO> save(@Valid @RequestBody ConsultDTO dto){
        Consult obj = service.save(this.convertToEntity(dto));
        //localhost:8080/consults/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsult()).toUri();
        return ResponseEntity.created(location).build();
    }*/

    @PostMapping
    public ResponseEntity<ConsultDTO> save(@Valid @RequestBody ConsultListExamDTO dto){
        Consult cons = this.convertToEntity(dto.getConsult());
        //List<Exam> exams = dto.getLstExam().stream().map(e -> modelMapper.map(e, Exam.class)).collect(Collectors.toList())
        List<Exam> exams = modelMapper.map(dto.getLstExam(), new TypeToken<List<Exam>>(){}.getType());

        Consult obj = service.saveTransactional(cons, exams);
        //localhost:8080/consults/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsult()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ConsultDTO dto){
        dto.setIdConsult(id);
        Consult obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Min(1) @PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ConsultDTO> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<ConsultDTO> resource = EntityModel.of(this.convertToDto(service.findById(id)));
        //localhost:8080/consults/4
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link1.withRel("consult-info1"));
        resource.add(link2.withRel("consult-info2"));

        return resource;
    }

    private ConsultDTO convertToDto(Consult obj){
        return modelMapper.map(obj, ConsultDTO.class);
    }

    private Consult convertToEntity(ConsultDTO dto){
        return modelMapper.map(dto, Consult.class);
    }

}
