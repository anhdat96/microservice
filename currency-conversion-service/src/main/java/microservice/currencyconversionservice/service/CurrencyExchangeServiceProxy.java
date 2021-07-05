package microservice.currencyconversionservice.service;

import microservice.currencyconversionservice.config.RibbonConfiguration;
import microservice.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name= "currency-exchange-service",url = "localhost:8000")
// when we want to talk to multiple instance of currency-exchange-service we do not need the URI
//@FeignClient(name= "currency-exchange-service")
//@RibbonClient(name = "currency-exchange-service")
@FeignClient(name= "netflix-zulu-gateway-server",url = "localhost:8765")
public interface CurrencyExchangeServiceProxy {

//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
//    public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
