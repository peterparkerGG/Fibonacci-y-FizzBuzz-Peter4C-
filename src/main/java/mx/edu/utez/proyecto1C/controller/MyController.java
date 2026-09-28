package mx.edu.utez.proyecto1C.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1C.controller.dto.RequestBodyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my-services")
public class MyController {

    // Cambia esta variable por tu nombre real
    private final String NOMBRE_ALUMNO = "Pedro Gael Bahena Hernández";

    @GetMapping
    public String miPrimerServicio(){
        return "Hello world";
    }

    @GetMapping("/servicio2")
    public String servicio2(){
        return "segundo servicio";
    }

    @PostMapping
    public String servicip3(){
        return "Este es el servicio 3";
    }

    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id){
        return "El path variable es " + id;
    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payload);
    }
    // SERVICIO 1: FizzBuzz

    @GetMapping("/fizzbuzz/{n}")
    public String fizzBuzz(@PathVariable int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return NOMBRE_ALUMNO;
    }
    // SERVICIO 2: Fibonacci

    @GetMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n) {
        if (n <= 0) {
            return NOMBRE_ALUMNO;
        }

        long a = 0;
        long b = 1;

        if (n == 1) {
            System.out.println(a);
        } else {
            System.out.println(a);
            System.out.println(b);

            for (int i = 3; i <= n; i++) {
                long siguiente = a + b;
                System.out.println(siguiente);
                a = b;
                b = siguiente;
            }
        }
        return NOMBRE_ALUMNO;
    }
}