package microservice.controller;

import microservice.entity.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionServiceController {


    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionService conversion(@PathVariable String from , @PathVariable String to, @PathVariable String quantity){

        return new CurrencyConversionService(1l,from,to,BigDecimal.ONE,BigDecimal.ONE,quantity,0);
    }

}
