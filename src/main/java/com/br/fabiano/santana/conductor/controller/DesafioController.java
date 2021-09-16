package com.br.fabiano.santana.conductor.controller;


import com.br.fabiano.santana.conductor.response.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
})
public class DesafioController {
    @ApiOperation(value = "Greets the world or Niteroi")
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces="application/json")
    public Greeting hello(@RequestParam(required = false) boolean niteroi) {

        Greeting greeting = new Greeting("Hello world");

        if (niteroi) {
            greeting.setMessage(greeting.getMessage().replace("world", "Niteroi"));
        }

        return greeting;
    }

    @ApiOperation(value = "Greets a person given her name")
    @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting get(@PathVariable String name) {

        return new Greeting("Hello, " + name);
    }
}
