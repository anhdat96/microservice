package microservice.currencyexchangeservice.controller;

import microservice.currencyexchangeservice.entity.ExchangeValue;
import microservice.currencyexchangeservice.repository.ExchangeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeServiceRepository exchangeServiceRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to
                                               ){
        List<ExchangeValue> ex2 = exchangeServiceRepository.findByExchangeFromAndExchangeTo(from,to);
        return ex2.get(0);
    }


}
