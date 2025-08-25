package com.example.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

import com.example.modelo.Topico;
import com.example.modelo.Curso;
import com.example.controller.dto.TopicoDto;

@RestController
public class TopicosController {
    
    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Duvida", "Duvida com spring", new Curso("Spring", "Programacao"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
